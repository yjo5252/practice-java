// epper 18_6.java

/*  �Է�: �� ���ڿ� (���� ����)
    ���: ��迭 ���� ����
*/

import java.util.Scanner;
public class EPPER6 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    s1 = s1.toLowerCase(); // ���ڿ��� �ҹ��ڷ� ��ȯ
    s2 = s2.toLowerCase();
    char[] c1 = s1.toCharArray(); //���ڿ��� �迭�� ��ȯ
    char[] c2 = s2.toCharArray();
    Arrays.sort(c1); //�������� ����
    Arrays.sort(c2);
    s1 = Arrays.toString(c1);
    s2 = Arrays.toString(c2); //�ٽ� String ��ü�� �ٲ㼭

    if (s1.equals(s2)) System.out.println("Yes");
    else System.out.println("No");
    }
}
