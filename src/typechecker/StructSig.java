package typechecker;

import ast.TypeRef;
import java.util.List;

public class StructSig {
  public final List<String> fieldNames;
  public final List<TypeRef> paramTypes;

  public StructSig(List<String> fn, List<TypeRef> p) {
    fieldNames = fn;
    paramTypes = p;
  }
}
