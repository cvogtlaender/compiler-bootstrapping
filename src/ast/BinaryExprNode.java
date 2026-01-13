package ast;

import visitors.AstVisitor;

public class BinaryExprNode implements ExprNode {
  public final String op;
  public final ExprNode left, right;

  public BinaryExprNode(String o, ExprNode l, ExprNode r) {
    op = o;
    left = l;
    right = r;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
