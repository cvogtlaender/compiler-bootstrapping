package visitors;

import ast.*;

public interface AstVisitor<R> {

  R visit(IntLitNode n);

  R visit(BoolLitNode n);

  R visit(StringLitNode n);

  R visit(NullLitNode n);

  R visit(VarNode n);

  R visit(UnaryExprNode n);

  R visit(BinaryExprNode n);

  R visit(IfNode n);

  R visit(LetNode n);

  R visit(CallNode n);

  R visit(FieldNode n);

  R visit(BlockNode n);
}
