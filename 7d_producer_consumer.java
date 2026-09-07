// 7d) Write a JAVA program Producer Consumer Problem

import java.lang.*;

class A {

  int n;
  boolean b = false;

  synchronized int get() {
    if (!b) try {
      wait();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("Got:" + n);
    b = false;
    notify();
    return n;
  }

  synchronized void put(int n) {
    if (b) try {
      wait();
    } catch (Exception e) {
      System.out.println(e);
    }
    this.n = n;
    b = true;
    System.out.println("Put:" + n);
    notify();
  }
}

class producer implements Runnable {

  A a1;
  Thread t1;

  producer(A a1) {
    this.a1 = a1;
    t1 = new Thread(this);
    t1.start();
  }

  public void run() {
    for (int i = 1; i <= 10; i++) {
      a1.put(i);
    }
  }
}

class consumer implements Runnable {

  A a1;
  Thread t1;

  consumer(A a1) {
    this.a1 = a1;
    t1 = new Thread(this);
    t1.start();
  }

  public void run() {
    for (int j = 1; j <= 10; j++) {
      a1.get();
    }
  }
}

class SevenD {

  public static void main(String[] args) {
    A a1 = new A();
    producer p1 = new producer(a1);
    consumer c1 = new consumer(a1);
  }
}
