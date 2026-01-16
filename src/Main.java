import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.xminLexer;
import antlr.xminParser;

import ast.*;
import codegen.JavaTranspiler;
import environment.Builtins;
import environment.functions.CharAt;
import environment.functions.Ord;
import environment.functions.Print;
import environment.functions.PrintInt;
import environment.functions.StrLen;
import environment.functions.SubStr;
import visitors.ASTBuildVisitor;
import visitors.TypeCheckVisitor;

import typechecker.Env;
import typechecker.FunSig;
import typechecker.StructSig;
import typechecker.TypeError;

public class Main {
  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("Usage: java Main <file.xmin>");
      return;
    }
    String text = Files.readString(Path.of(args[0]));

    CharStream input = CharStreams.fromString(text);
    xminLexer lexer = new xminLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    xminParser parser = new xminParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new DiagnosticErrorListener());

    ParseTree tree = parser.prog();

    ASTBuildVisitor builder = new ASTBuildVisitor();
    Prog prog = (Prog) builder.visit(tree);

    System.out.println("Parsed functions: " + prog.functions.size());
    for (FunDef f : prog.functions) {
      System.out.println("- " + f.name + " : " + f.returnType.name);
    }

    Map<String, FunSig> funs = new HashMap<>();
    for (FunDef f : prog.functions) {
      if (funs.containsKey(f.name)) {
        throw new TypeError("Duplicate function: " + f.name);
      }
      List<TypeRef> pts = f.params.stream()
          .map(p -> p.type)
          .collect(Collectors.toList());

      funs.put(f.name, new FunSig(f.returnType, pts));
    }

    Map<String, StructSig> structs = new HashMap<>();
    for (StructDef s : prog.structs) {
      if (structs.containsKey(s.name)) {
        throw new TypeError("Duplicate struct: " + s.name);
      }

      List<String> names = s.params.stream()
          .map((f) -> f.name)
          .collect(Collectors.toList());
      List<TypeRef> fds = s.params.stream()
          .map((f) -> f.type)
          .collect(Collectors.toList());

      structs.put(s.name, new StructSig(names, fds));
    }

    IdentityHashMap<ExprNode, TypeRef> types = new IdentityHashMap<>();

    // Builtin functions
    Builtins b = new Builtins();
    b.register(new Print());
    b.register(new PrintInt());
    b.register(new CharAt());
    b.register(new StrLen());
    b.register(new SubStr());
    b.register(new Ord());

    for (FunDef f : prog.functions) {
      Env env = new Env();
      for (Param p : f.params) {
        env.put(p.name, p.type);
      }

      TypeCheckVisitor tc = new TypeCheckVisitor(env, funs, structs, types, b);
      TypeRef bodyT = f.body.accept(tc);

      if (!bodyT.name.equals(f.returnType.name)) {
        throw new TypeError("Function '" + f.name + "' returns " + bodyT.name +
            " but declared " + f.returnType.name);
      }
    }

    String javaOutput = JavaTranspiler.emitJava(prog, types, b, structs);

    Path outDir = Path.of("dist");
    Files.createDirectories(outDir);

    Files.writeString(outDir.resolve("Out.java"), javaOutput);
    System.out.println("Program transpiled");
  }
}
