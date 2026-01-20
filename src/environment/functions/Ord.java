package environment.functions;

import java.util.List;

import ast.ExprNode;
import ast.TypeRef;
import codegen.EmitResult;
import environment.Builtin;
import typechecker.FunSig;
import visitors.JavaTranspileVisitor;

public class Ord implements Builtin {

  @Override
  public String name() {
    return "ord";
  }

  @Override
  public FunSig signature() {
    return new FunSig(TypeRef.INT, List.of(TypeRef.STRING));
  }

  @Override
  public EmitResult emit(JavaTranspileVisitor v, List<ExprNode> args) {
    if (args.size() != 1)
      throw new RuntimeException("ord expects exactly one argument");

    EmitResult a = v.emit(args.get(0));

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(a.javaStatements);

    String temp = v.getTemps().next();
    r.javaStatements.add("char " + temp + " = " + a.value + ".charAt(0);");

    String temp1 = v.getTemps().next();
    r.javaStatements.add("int " + temp1 + " = (int) " + temp + ";");

    r.value = temp1;
    return r;
  }
}
