public class Out {
  static int fact(int n) {
    boolean temp0 = (n == 0);
    int temp1;
    if (temp0) {
        temp1 = 1;
    } else {
        int temp2 = (n - 1);
        int temp3 = fact(temp2);
        int temp4 = (n * temp3);
        temp1 = temp4;
    }
    return temp1;
  }

  static int main() {
    int temp0 = fact(5);
    int test = temp0;
    int temp1 = (test + 1);
    int x = 5;
    return 2;
  }

  public static void main(String[] args) {
    System.out.println(main());
  }
}
