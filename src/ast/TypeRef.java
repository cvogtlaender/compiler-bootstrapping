package ast;

public class TypeRef {
  public final String name;

  public TypeRef(String n) {
    name = n;
  }

  public static final TypeRef INT = new TypeRef("int");
  public static final TypeRef BOOL = new TypeRef("bool");
  public static final TypeRef STRING = new TypeRef("string");

  public static final boolean isPrimitive(TypeRef t) {
    return t.equals(TypeRef.INT) || t.equals(TypeRef.BOOL) || t.equals(TypeRef.STRING);
  }
}
