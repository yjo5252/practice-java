import java.util.*;
public class Q1{
  public static void main(String[] args) {
    Scanner sc = new Scannr(System.in);
    int n = sc.nextInt(); //입력받을 숫자의 개수
    int arr[] = new int[n+1]; //ㅣ입력받을 수를 담을 배열
    for (int k = 1; k <= n; k++){
      arr[k] = sc.nextInt();
    }
    int i = sc.nextInt(); //index i 부터
    int j = sc.nextInt(); //index j 까지
    int ans = 0;

    for (int k = 1; k <= n; k++){
      ans += arr[k];
    }
    System.out.println(ans);    
  }
}
