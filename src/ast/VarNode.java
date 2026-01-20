package ast;

import visitors.AstVisitor;

public class VarNode implements ExprNode {
  public final String name;

  public VarNode(String n) {
    name = n;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
