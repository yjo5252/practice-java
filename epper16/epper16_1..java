// epper 16_1.java

/*  입력: 양의 정수 n을 입력
  출력: 1 + 1/2 + 1/3 + ....+1//n을 소수 둘째 자리까지 출력
*/
import java.util.*;

public class EPPER1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(Ssytem.in);
    int n = sc.nextInt();
    double sum = 0;
    for(int i=1; i<= n; i++)sum+= 1/(double)i;
    System.out.printf("%.2f\n", sum);
  }
}
