package environment.functions;

import java.util.List;

import ast.ExprNode;
import ast.TypeRef;
import codegen.EmitResult;
import environment.Builtin;
import typechecker.FunSig;
import visitors.JavaTranspileVisitor;

public class PrintInt implements Builtin {

  @Override
  public String name() {
    return "printInt";
  }

  @Override
  public FunSig signature() {
    return new FunSig(TypeRef.INT, List.of(TypeRef.INT));
  }

  @Override
  public EmitResult emit(JavaTranspileVisitor v, List<ExprNode> args) {
    if (args.size() != 1)
      throw new RuntimeException("printInt expects exactly one argument");

    EmitResult a = v.emit(args.get(0));

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(a.javaStatements);
    r.javaStatements.add("System.out.print(" + a.value + ");");
    r.value = "0";
    return r;
  }
}
