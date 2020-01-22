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

    //두 문자열의 알파벳 구성 확인 목적의 배열 생성
    int s1Alpha[] = new int[26];
    int s2Alpha[] = new int[26];
    //배열 초기화
    for (int i = 0; i <26; i++) {
      s1Alpha[i] = s2Alpha[i] = 0;
    }
    // 재배열 가능한 지를 체크하는 flag
    boolean rearrange = true;

    //각 문자열에 알파벳이 몇개 있는지 순차적으로 탐색
    if (s1.length == s2.length){
      for(int i = 0; i < s1.length(); i++){
       // String CharAt(i) method : i번빼 자리 char 값을 리턴한다.
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
