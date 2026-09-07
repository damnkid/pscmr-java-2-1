// 7b) Write a program illustrating is Alive and join ()


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

class SevenB {

  public static void main(String[] args) {
    A a1 = new A();
    B b1 = new B();
    C c1 = new C();
    a1.start();
    b1.start();
    c1.start();
    System.out.println(a1.isAlive());
    System.out.println(b1.isAlive());
    System.out.println(c1.isAlive());
    try {
      a1.join();
      b1.join();
      c1.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    System.out.println(a1.isAlive());
    System.out.println(b1.isAlive());
    System.out.println(c1.isAlive());
  }
}
