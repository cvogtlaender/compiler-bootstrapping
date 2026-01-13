package ast;

import visitors.AstVisitor;

public class BoolLitNode implements ExprNode {
  public final boolean value;

  public BoolLitNode(boolean v) {
    value = v;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
