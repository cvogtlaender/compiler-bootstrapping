package ast;

import visitors.AstVisitor;

public class IfNode implements ExprNode {
  public final ExprNode cond, thenBranch, elseBranch;

  public IfNode(ExprNode c, ExprNode t, ExprNode e) {
    cond = c;
    thenBranch = t;
    elseBranch = e;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
