package ast;

import visitors.AstVisitor;

public interface ExprNode {

  <T> T accept(AstVisitor<T> visitor);
}
