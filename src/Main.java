import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.xminLexer;
import antlr.xminParser;

import ast.*;
import transpiler.JavaTranspiler;
import visitors.ASTBuildVisitor;
import visitors.TypeCheckVisitor;

import typechecker.Env;
import typechecker.FunSig;
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

    IdentityHashMap<ExprNode, TypeRef> types = new IdentityHashMap<>();

    for (FunDef f : prog.functions) {
      Env env = new Env();
      for (Param p : f.params) {
        env.put(p.name, p.type);
      }

      TypeCheckVisitor tc = new TypeCheckVisitor(env, funs, types);
      TypeRef bodyT = f.body.accept(tc);

      if (!bodyT.name.equals(f.returnType.name)) {
        throw new TypeError("Function '" + f.name + "' returns " + bodyT.name +
            " but declared " + f.returnType.name);
      }
    }

    String javaOutput = JavaTranspiler.emitJava(prog, types);
    Files.writeString(Path.of("Out.java"), javaOutput);
    System.out.println("Program transpiled");
  }
}
