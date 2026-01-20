package ast;

import visitors.AstVisitor;

public class IntLitNode implements ExprNode {
  public final int value;

  public IntLitNode(int v) {
    value = v;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
