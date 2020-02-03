// epper 16_3.java

/*  입력: 양의 정수 n
  출력: 회문 여부 출력
  */

import java.util.*;

public class EPPER3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(Ssytem.in);
    String str1 = sc.next();
    StringBuffer rev = new StringBuffer(str1);
    rev = rev.reverse();
    String str2 = new String(rev);

    if(str1.equals(str2)) System.out.println("T");
    else System.out.println("F");
  }
}
