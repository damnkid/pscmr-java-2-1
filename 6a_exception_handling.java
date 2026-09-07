// 6a) Write a JAVA program that describes exception handling mechanism

import java.lang.*;

class SixA {

  public static void main(String[] args) {
    try {
      int a = 10,
        b = 0;
      int c = a / b;
      System.out.println(c);
    } catch (ArithmeticException e) {
      System.out.println(e);
    }
    System.out.println("After the catch statement");
  }
}
