// 6d) Write a JAVA program for creation of User Defined Exception

import java.lang.*;

class A extends Exception {

  A(String s1) {
    super(s1);
  }
}

class SixD {

  public static void main(String[] args) {
    try {
      throw new A("demo ");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
