// epper 17_1.java

/*  입력: OX 결과
    출력: 점수
*/

import java.util.Scanner;
public class EPPER5 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String input;
    int continuity=0;
    int score = 0;

    input = sc.nextLine();

    for (int i=0; i <input.length(); i++){
      if (input.charAt(i) =='O'){
        continuity++;
        score += continuity;
      }
      else{ continuity = 0;}
    }
    System.out.println(score);
  }
}
