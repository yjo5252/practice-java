import java.util.*;
public class Q1{
  public static void main(String[] args) {
    Scanner sc = new Scannr(System.in);
    int n = sc.nextInt(); //�Է¹��� ������ ����
    int arr[] = new int[n+1]; //���Է¹��� ���� ���� �迭
    for (int k = 1; k <= n; k++){
      arr[k] = sc.nextInt();
    }
    int i = sc.nextInt(); //index i ����
    int j = sc.nextInt(); //index j ����
    int ans = 0;

    for (int k = 1; k <= n; k++){
      ans += arr[k];
    }
    System.out.println(ans);    
  }
}
