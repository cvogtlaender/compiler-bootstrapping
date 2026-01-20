package codegen;

import ast.TypeRef;

public class JavaType {

  public static String of(TypeRef typeRef) {
    return switch (typeRef.name) {
      case "bool" -> "boolean";
      case "string" -> "String";
      default -> typeRef.name;
    };
  }
}
