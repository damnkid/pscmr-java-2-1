// 4b) Write a JAVA program to implement multi level Inheritance

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

class C extends B {

  C() {
    System.out.println("Inside C's Constructor");
  }
}

class FourB {

  public static void main(String[] args) {
    new C();
    // C c1 = new C();
  }
}
