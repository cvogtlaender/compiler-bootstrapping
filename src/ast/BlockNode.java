package ast;

import java.util.List;

import visitors.AstVisitor;

public class BlockNode implements ExprNode {
  public final List<ExprNode> exprs;

  public BlockNode(List<ExprNode> e) {
    exprs = e;
  }

  @Override
  public <R> R accept(AstVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
