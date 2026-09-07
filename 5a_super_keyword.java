// 5a) Write a JAVA program give example for “super” keyword.

import java.lang.*;

//Using super to call super class constructor (With parameters)
class A {

  int l, b;

  A(int u, int v) {
    l = u;
    b = v;
  }
}

class B extends A {

  int h;

  B(int u, int v, int w) {
    super(u, v);
    h = w;
  }

  int volume() {
    return l * b * h;
  }
}

class FiveA {

  public static void main(String[] args) {
    B b1 = new B(30, 20, 30);
    int r = b1.volume();
    System.out.println("The vol. is: " + r);
  }
}
