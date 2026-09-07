// 2a) Write a JAVA program to search for an element in a given list of elements using binary
// search mechanism.

import java.lang.*;
import java.util.Scanner;

class TwoA {

  public static void main(String[] args) {
    int n, i, num, first, last, middle;
    int a[] = new int[20];
    Scanner s = new Scanner(System.in);
    System.out.println("Enter total number of elements:");
    n = s.nextInt();
    System.out.println("Enter elements in sorted order:");
    for (i = 0; i < n; i++) a[i] = s.nextInt();
    System.out.println("Enter the search value:");
    num = s.nextInt();
    first = 0;
    last = n - 1;
    middle = (first + last) / 2;
    while (first <= last) {
      if (a[middle] < num) first = middle + 1;
      else if (a[middle] == num) {
        System.out.println("number found");
        break;
      } else {
        last = middle - 1;
      }
      middle = (first + last) / 2;
    }
    if (first > last) System.out.println("Number not found");
    s.close();
  }
}
