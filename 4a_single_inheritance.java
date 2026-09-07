// 4a) Write a JAVA program to implement Single Inheritance

import java.lang.*;

class A {

  A() {
    System.out.println("Inside A's Constructor");
  }
}

class B extends A {

  B() {
    System.out.println("Inside B's Constructor");
  }
}

class FourA {

  public static void main(String[] args) {
    new B();
    // B b1=new B();
  }
}
