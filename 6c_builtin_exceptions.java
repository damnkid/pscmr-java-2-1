// 6c) Write a JAVA program for creation of Java Built-in Exceptions

import java.lang.*;

class SixC {

  public static void main(String[] args) {
    try {
      int a = 10,
        b = 0;
      int c = a / b;
      System.out.println(c);
      String d = "Hello";
      System.out.println(d.charAt(0));
      String e = "This is like chipping ";
      char f = e.charAt(24);
      System.out.println(f);
    } catch (ArithmeticException x) {
      System.out.println(x);
    } catch (NullPointerException x) {
      System.out.println(x);
    } catch (StringIndexOutOfBoundsException x) {
      System.out.println(x);
    }
  }
}
