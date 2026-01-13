package ast;

import java.util.List;

import visitors.AstVisitor;

public class CallNode implements ExprNode {
  public final ExprNode callee;
  public final List<ExprNode> args;

  public CallNode(ExprNode c, List<ExprNode> a) {
    callee = c;
    args = a;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
