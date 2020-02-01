// epper 17_5.java

/*  입력: 실의 길이 n
    출력: 삼각형의 개수
*/

import java.util.Scanner;
public class EPPER5 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n;
    int total = 0;

    n = sc.nextInt();

    for (int i=1; i<len; i++){
      for (int j=i; j<n; j++) {
        for (int k= j; k<n; k++){
          if (i+j+k == n && (i+j)>k){
            System.out.println("i j k is "+ i+ " "+j+" "+k);
            total++;
          }
        }
      }
    }
    System.out.println(total);
  }
}
