package ast;

import visitors.AstVisitor;

public class NullLitNode implements ExprNode {

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
