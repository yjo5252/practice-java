// epper 18_6.java

/*  입력: 두 문자열 (공백 구분)
    출력: 재배열 가능 여부
*/

import java.util.Scanner;
public class EPPER6 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    s1 = s1.toLowerCase(); // 문자열을 소문자로 변환
    s2 = s2.toLowerCase();
    char[] c1 = s1.toCharArray(); //문자열을 배열로 전환
    char[] c2 = s2.toCharArray();
    Arrays.sort(c1); //오름차순 정렬
    Arrays.sort(c2);
    s1 = Arrays.toString(c1);
    s2 = Arrays.toString(c2); //다시 String 객체로 바꿔서

    if (s1.equals(s2)) System.out.println("Yes");
    else System.out.println("No");
    }
}
