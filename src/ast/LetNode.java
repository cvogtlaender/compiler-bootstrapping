package ast;

import visitors.AstVisitor;

public class LetNode implements ExprNode {
    public final TypeRef type;
    public final String name;
    public final ExprNode value, body;

    public LetNode(TypeRef t, String n, ExprNode v, ExprNode b) {
        type = t;
        name = n;
        value = v;
        body = b;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
