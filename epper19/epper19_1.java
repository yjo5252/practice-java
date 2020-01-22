//epper19_1.java
// À±³â Ã£±â 

import java.util.Scanner;
public class Q1 {
  public static void main(String[]args) {
    //TODO Auto-generated method stub
    int year;
    Scanner sc = new Scanner(System.in);

    year = sc.nextInt();

    if ((year % 4 == 0 && year %100 != 0) || year % 400 == 0)
      System.out.println("T");
    else
      System.out.println("F");
  }
}
