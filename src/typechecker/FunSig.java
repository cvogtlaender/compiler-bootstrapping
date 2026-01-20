package typechecker;

import ast.TypeRef;
import java.util.List;

public class FunSig {
  public final TypeRef returnType;
  public final List<TypeRef> paramTypes;

  public FunSig(TypeRef r, List<TypeRef> p) {
    returnType = r;
    paramTypes = p;
  }
}
