package typechecker;

import ast.TypeRef;
import java.util.*;

public class Env {
  private final Env parent;
  private final Map<String, TypeRef> vars = new HashMap<>();

  public Env() {
    this.parent = null;
  }

  private Env(Env parent) {
    this.parent = parent;
  }

  public Env child() {
    return new Env(this);
  }

  public void put(String name, TypeRef type) {
    vars.put(name, type);
  }

  public TypeRef get(String name) {
    TypeRef t = vars.get(name);
    if (t != null)
      return t;
    return parent == null ? null : parent.get(name);
  }
}
