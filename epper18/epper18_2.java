// epper 18_2.java

/*  �Է�: ��ȣǥ
    ���: �� ��ȣ (/15)& �� �ȿ����� ��ȣ (%15)
*/

import java.util.Scanner;
public class EPPER2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextint();
    int num = n%15;
    if(num == 0) num = 15; // �������� 0�� ���� 15��
    System.out.println((n+14)/15 + " " + num);
  }
}
