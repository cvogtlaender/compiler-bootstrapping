package ast;

import java.util.List;

public class FunDef {
  public final TypeRef returnType;
  public final String name;
  public final List<Param> params;
  public final ExprNode body;

  public FunDef(TypeRef r, String n, List<Param> p, ExprNode b) {
    returnType = r;
    name = n;
    params = p;
    body = b;
  }
}
