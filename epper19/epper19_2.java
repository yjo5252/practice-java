//epper19_2.java
// 평균보다 큰 점수의 비율
//소수점 3째자리까지 표현

import java.util.Scanner;
public class Q2 {
  public static void main(String[]args) {

    int i , N, count=0;
    int sum = 0, avg = 0;
    int [] scores;// java 배열 선언

    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();     //학생 수 입력 -> N에 저장
    scores = new int[N];  //배열 생성

    for (i = 0; i < N; i++){
      scores[i] = sc.nextInt();
      sum += scores[i];
    }
    avg = (double)sum / N; //평균 구하기  'double'

    while (i < N){
      if(scores[i] > avg) count++;
    }
    System.out.println(String.format("%.3f", (count/N)*100));// 소수점 3째자리까지 
  }
}
