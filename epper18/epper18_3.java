// epper 18_3.java

/*  입력: 영어 알파벳 (하이폰(-)으로 구분)
    출력: 대문자로 구성된 축약문
*/

import java.util.*;
public class EPPER3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    //토큰 형성 코드
    //"str"을 자른다. "-"을 기준으로. false option: "-"제외.
    StringTokenizer st = StringTokenizer(str,"-",false);

    while (st.hasMostTokens()){//토큰이 남아있을 때까지 반복
      System.out.println(st.nextToken().charAt(0)); ///토큰의 첫 글자
    }
    System.out.println(); //줄바꿈 프린트 
    }
}
