// epper 18_5.java

/*  입력: 8개 숫자 (공백 구분)
    출력: ascending, descending, mixed 판단
*/

import java.util.*;
public class EPPER5 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    //기준 설정
    String asc = "1 2 3 4 5 6 7 8"; //ascending의 문자열
    String desc = "8 7 6 5 4 3 2 1"; //descending의 문자열
    //문자열 입력
    String str = sc.next();

    if (asc.equals(str)) System.out.println("ascending");
    else if (desc.equals(str)) System.out.println("descending");
    else System.out.println("mixed");

    }
}
