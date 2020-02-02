// epper 16_2.java

/*  입력: 10개의 정수를 공백으로 구분 입력
  출력: 최대값 최소값 출력
  */
import java.util.Arrays;
import java.util.*;

public class EPPER2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(Ssytem.in);
    int arr[] = new int[10];
    for(int i=0; i< 10; i++) arr[i] = sc.nextInt();
    Arrays.sort(arr);
    System.out.prinln("최대값:"+arr[9]);
    System.out.println("최소값:"+arr[0]);
  }
}
