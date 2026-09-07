// 3a) Write a JAVA program to implement class mechanism. Create a class, methods and
// invoke them inside main method.

import java.lang.*;

class Cake {

  int l = 10,
    b = 20;

  void display() {
    System.out.println(l);
    System.out.println(b);
  }
}

class ThreeA {

  public static void main(String[] args) {
    Cake a1 = new Cake();
    a1.display();
  }
}
