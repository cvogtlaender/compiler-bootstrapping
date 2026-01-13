package ast;

import java.util.List;

public class Prog {
  public final List<FunDef> functions;

  public Prog(List<FunDef> f) {
    functions = f;
  }
}
