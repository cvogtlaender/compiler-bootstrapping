package ast;

public class Param {
  public final TypeRef type;
  public final String name;

  public Param(TypeRef t, String n) {
    type = t;
    name = n;
  }
}
