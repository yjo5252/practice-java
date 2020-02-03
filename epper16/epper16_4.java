// epper 16_4.java

/*  입력: 자연수  n
  출력: n의 이진수 
  */

import java.util.*;

public class EPPER4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(Ssytem.in);
    int n = sc.nextInt();
    printBinary(n);
    System.out.println(n);
  }
  public static void printBinary(int n){
    if(n==0) return;
    else{
      printBinary(n/2);
      System.our.print(n%2);
    }
  }
}
