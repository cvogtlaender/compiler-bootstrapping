package transpiler;

public class TempGen {
  private int i = 0;

  public String next() {
    return "temp" + i++;
  }
}
