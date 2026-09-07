// 7c) Write a Program illustrating Daemon Threads.

import java.lang.*;

class A extends Thread {

  public void run() {
    if (Thread.currentThread().isDaemon()) System.out.println("daemon thread work");
    else System.out.println("user thread work");
  }
}

class SevenC {

  public static void main(String[] args) {
    A a1 = new A();
    A a2 = new A();
    A a3 = new A();
    a1.setDaemon(true);
    a1.start();
    a2.start();
    a3.start();
  }
}
