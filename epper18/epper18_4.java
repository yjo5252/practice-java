// epper 18_4.java

/*  �Է�: Ȧ���� ���� ���� n
    ���: ���̾Ƹ�� ���
    (1) i=0 ~ n/2 : j = n/2-i ~ 1, 0 ~ 2*i
    (2) i=n/2-1 ~ 0 : j = n/2-i ~ 1, 0 ~ 2*i
    �ܿ�!����!
*/

import java.util.Scanner;
public class EPPER4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i=0; i<n/2+1; i++){//�� �ﰢ���� n/2+1 ��}
      for (int j=n/2-i; j>0; j--)System.out.print(" ");
      for (int j=0; j<=2*i; j++) System.out.print("*");
      System.out.println();
    }
      //���� form���� i�� �ݴ�� 
    for (int i=n/2-1;i>=0; i--){//�Ʒ� �ﰢ���� n/2��,

      for (int j=n/2-i; j>0; j--) System.out.print(" ");
      for (int j=0; j<= 2*i; j++) System.out.print("*");
      System.out.println();
    }
}
