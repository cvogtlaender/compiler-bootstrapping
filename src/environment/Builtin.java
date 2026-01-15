package environment;

import java.util.List;

import ast.ExprNode;
import transpiler.EmitResult;
import typechecker.FunSig;
import visitors.JavaTranspileVisitor;

public interface Builtin {

  String name();

  FunSig signature();

  EmitResult emit(JavaTranspileVisitor v, List<ExprNode> args);
}
