package ast;

import visitors.AstVisitor;

public class UnaryExprNode implements ExprNode {
  public final String op;
  public final ExprNode expr;

  public UnaryExprNode(String o, ExprNode e) {
    op = o;
    expr = e;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
