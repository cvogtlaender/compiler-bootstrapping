package ast;

import java.util.List;

public class StructDef {
  public final String name;
  public final List<Param> params;

  public StructDef(String n, List<Param> p) {
    name = n;
    params = p;
  }
}
