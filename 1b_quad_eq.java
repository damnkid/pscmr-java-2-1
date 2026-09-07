// 1b) Write a java program that display the roots of a quadratic equation ax2+bx=0. Calculate the discriminate D and basing on value of D, describe the nature of root.

  import java.lang.*;
  import java.util.*;

  class OneB1 {

    public static void main(String[] args) {
      int a, b, c;
      double r1, r2, D;
      Scanner s = new Scanner(System.in);
      System.out.println("Given quadratic equation:ax^2+bx+c");
      System.out.print("Enter a:");
      a = s.nextInt();
      System.out.print("Enter b:");
      b = s.nextInt();
      System.out.print("Enter c:");
      c = s.nextInt();
      D = b * b - 4 * a * c;
      if (D > 0) {
        System.out.println("Roots are real and unequal");
        r1 = (-b + Math.sqrt(D)) / (2 * a);
        r2 = (-b - Math.sqrt(D)) / (2 * a);
        System.out.println("First root is:" + r1);
        System.out.println("Second root is:" + r2);
      } else if (D == 0) {
        System.out.println("Roots are real and equal");
        r1 = -b / (2 * a);
        r2 = -b / (2 * a);
        System.out.println("Root:" + r1);
      } else {
        System.out.println("Roots are imaginary");
      }
      s.close();
    }
  }
