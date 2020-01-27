// epper 18_2.java

/*  입력: 번호표
    출력: 방 번호 (/15)& 방 안에서의 번호 (%15)
*/

import java.util.Scanner;
public class EPPER2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextint();
    int num = n%15;
    if(num == 0) num = 15; // 나머지가 0인 경우는 15번
    System.out.println((n+14)/15 + " " + num);
  }
}
