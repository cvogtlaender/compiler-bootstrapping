package ast;

import java.util.List;

public class Prog {
  public final List<FunDef> functions;
  public final List<StructDef> structs;

  public Prog(List<FunDef> f, List<StructDef> s) {
    functions = f;
    structs = s;
  }
}
