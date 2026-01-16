package environment.functions;

import java.util.List;

import ast.ExprNode;
import ast.TypeRef;
import codegen.EmitResult;
import environment.Builtin;
import typechecker.FunSig;
import visitors.JavaTranspileVisitor;

public class SubStr implements Builtin {

  @Override
  public String name() {
    return "substr";
  }

  @Override
  public FunSig signature() {
    return new FunSig(TypeRef.STRING, List.of(TypeRef.STRING, TypeRef.INT, TypeRef.INT));
  }

  @Override
  public EmitResult emit(JavaTranspileVisitor v, List<ExprNode> args) {
    if (args.size() != 3)
      throw new RuntimeException("strlen expects three arguments");

    EmitResult a = v.emit(args.get(0));
    EmitResult b = v.emit(args.get(1));
    EmitResult c = v.emit(args.get(2));

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(a.javaStatements);

    String temp = v.getTemps().next();
    r.javaStatements.add("String " + temp + " = " + a.value + ".substring(" + b.value + ", " + c.value + ");");
    r.value = temp;

    return r;
  }
}
