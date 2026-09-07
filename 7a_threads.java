// 7a) Write a JAVA program that creates threads by extending Thread class. First thread display
// “Good Morning “every 1 sec, the second thread displays “Hello “every 2 seconds and the
// third display “Welcome” every 3 seconds, (Repeat the same by implementing Runnable)

import java.lang.*;

class A extends Thread {

  public void run() {
    try {
      for (int i = 1; i <= 10; i++) {
        sleep(1000);
        System.out.println("good morning");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class B extends Thread {

  public void run() {
    try {
      for (int j = 1; j <= 10; j++) {
        sleep(2000);
        System.out.println("hello");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class C extends Thread {

  public void run() {
    try {
      for (int k = 1; k <= 10; k++) {
        sleep(3000);
        System.out.println("welcome");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

class SevenA {

  public static void main(String[] args) {
    A a1 = new A();
    B b1 = new B();
    C c1 = new C();
    a1.start();
    b1.start();
    c1.start();
  }
}
