package ast;

public class TypeRef {
  public final String name;

  public TypeRef(String n) {
    name = n;
  }

  public static final TypeRef INT = new TypeRef("int");
  public static final TypeRef BOOL = new TypeRef("bool");
  public static final TypeRef STRING = new TypeRef("string");

  @Override
  public String toString() {
    return this.name;
  }
}
