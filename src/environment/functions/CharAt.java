package environment.functions;

import java.util.List;

import ast.ExprNode;
import ast.TypeRef;
import codegen.EmitResult;
import environment.Builtin;
import typechecker.FunSig;
import visitors.JavaTranspileVisitor;

public class CharAt implements Builtin {

  @Override
  public String name() {
    return "charAt";
  }

  @Override
  public FunSig signature() {
    return new FunSig(TypeRef.STRING, List.of(TypeRef.STRING, TypeRef.INT));
  }

  @Override
  public EmitResult emit(JavaTranspileVisitor v, List<ExprNode> args) {
    if (args.size() != 2)
      throw new RuntimeException("charAt expects 2 arguments");

    EmitResult string = v.emit(args.get(0));
    EmitResult index = v.emit(args.get(1));

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(string.javaStatements);
    r.javaStatements.addAll(index.javaStatements);

    String s = v.getTemps().next();
    r.javaStatements.add(
        "String " + s + " = String.valueOf(" + string.value + ".charAt(" + index.value + "));");
    r.value = s;
    return r;
  }
}
