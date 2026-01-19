package environment.functions;

import java.util.List;

import ast.ExprNode;
import ast.TypeRef;
import codegen.EmitResult;
import environment.Builtin;
import typechecker.FunSig;
import visitors.JavaTranspileVisitor;

public class ReadFile implements Builtin {

  @Override
  public String name() {
    return "readFile";
  }

  @Override
  public FunSig signature() {
    return new FunSig(TypeRef.STRING, List.of(TypeRef.STRING));
  }

  @Override
  public EmitResult emit(JavaTranspileVisitor v, List<ExprNode> args) {
    if (args.size() != 1)
      throw new RuntimeException("readFile expects exactly one argument");

    EmitResult path = v.emit(args.get(0));

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(path.javaStatements);

    String temp = v.getTemps().next();
    r.javaStatements.add(
        "String " + temp + " = null;");

    r.javaStatements.add(
        "try { " + temp + " = java.nio.file.Files.readString(java.nio.file.Path.of(" + path.value + "));" +
            " } catch (java.io.IOException e) { " +
            "throw new RuntimeException(e);" +
            " }");

    r.value = temp;
    return r;
  }
}
