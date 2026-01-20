package ast;

import visitors.AstVisitor;

public class StringLitNode implements ExprNode {
  public final String value;

  public StringLitNode(String v) {
    value = v;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
