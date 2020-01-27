// epper 18_4.java

/*  입력: 홀수인 양의 정수 n
    출력: 다이아몬드 모양
    (1) i=0 ~ n/2 : j = n/2-i ~ 1, 0 ~ 2*i
    (2) i=n/2-1 ~ 0 : j = n/2-i ~ 1, 0 ~ 2*i
    외워!두자!
*/

import java.util.Scanner;
public class EPPER4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i=0; i<n/2+1; i++){//윗 삼각형은 n/2+1 줄}
      for (int j=n/2-i; j>0; j--)System.out.print(" ");
      for (int j=0; j<=2*i; j++) System.out.print("*");
      System.out.println();
    }
      //위의 form문과 i를 반대로 
    for (int i=n/2-1;i>=0; i--){//아래 삼각형은 n/2줄,

      for (int j=n/2-i; j>0; j--) System.out.print(" ");
      for (int j=0; j<= 2*i; j++) System.out.print("*");
      System.out.println();
    }
}
