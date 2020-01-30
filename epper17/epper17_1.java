// epper 17_1.java

/*  입력: 양의 정수 두개
    출력: 최대공약수 출력
*/

import java.util.Scanner;
public class EPPER1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String input;
    int a, b;
    int big, small;
    a = sc.nextInt();
    b = sc.nextInt();

    if (a > b) {
      big = a ;  small = b;
    }else{
      big = b;   small = a;
    }

    int mod = big % small;

    while(mod >0){
      big = small;
      small = mod;
      mod = big%small;
    }
    System.out.println(small);
  }
}
