package ast;

import visitors.AstVisitor;

public class FieldNode implements ExprNode {
  public final ExprNode target;
  public final String field;

  public FieldNode(ExprNode t, String f) {
    target = t;
    field = f;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
