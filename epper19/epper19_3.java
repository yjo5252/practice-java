//epper19_3.java
import java.util.Scanner;
public class Q3 {
  public static void main(String[]args) {
    Scanner sc = new Scanner(System.in);

    String s1, s2;
    s1 = sc.nextInt();
    s2 = sc.nextInt();

    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();

    //�� ���ڿ��� ���ĺ� ���� Ȯ�� ������ �迭 ����
    int s1Alpha[] = new int[26];
    int s2Alpha[] = new int[26];
    //�迭 �ʱ�ȭ
    for (int i = 0; i <26; i++) {
      s1Alpha[i] = s2Alpha[i] = 0;
    }
    // ��迭 ������ ���� üũ�ϴ� flag
    boolean rearrange = true;

    //�� ���ڿ��� ���ĺ��� � �ִ��� ���������� Ž��
    if (s1.length == s2.length){
      for(int i = 0; i < s1.length(); i++){
       // String CharAt(i) method : i���� �ڸ� char ���� �����Ѵ�.
        s1Alpha[s1.CharAt(i)-'a']++;
        s2Alpha[s2.CharAt(i)-'a']++;
      }

      for (int i =0; i < 26; i++){
        if (s1Alpha[i] != s2Alpha[i]){
          rearrange = false;
          break;
        }
      }
    }else
     rearragne = false;

     if (rearrange) System.out.println("T");
     else System.out.println("F");
    }
}
