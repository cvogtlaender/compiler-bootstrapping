package environment;

import java.util.HashMap;
import java.util.Map;

public class Builtins {

  private final Map<String, Builtin> builtins = new HashMap<>();

  public void register(Builtin b) {
    builtins.put(b.name(), b);
  }

  public Builtin get(String name) {
    return builtins.get(name);
  }

  public boolean has(String name) {
    return builtins.containsKey(name);
  }
}
