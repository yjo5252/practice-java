// epper 17_6.java

/*  입력: 양의 정수 A를 입력한다.
    출력: 모든 자리값이 등장하게 되는 숫자 A에 곱한 마지막 n을 출력
*/
import java.util.*;


public class EPPER6 {
  public static boolean checkN(int[] a){
    //배열에 0이 들어있는 지 확인하는 함수 (모두 0이될때까지 반복)
    for (int i=0; i<=9; i++){
      if (a[i]!=0) return false;
      }return true;
  }
  //main 함수
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int Nnum=0, num=0, cnt=0;
    String temp;
    char [] charArr;

    //배열 선언 및 초기화
    int arr[] = new int[11];
    for (int i=0; i<11; i++) arr[i] = 1;

    //초기 입력되는 정수값
    num = sc.nextInt();
    while(checkN(arr)==false){
      Nnum += num;
      cnt++;
    }
    //integer to charArray, char to numeric value

    temp = Integer.toString(Nnum);
    charArr = temp.toCharArray();
    for (int i=0 ; i<temp.length();i++) {
      arr[Character.getNumericValue(charArr[i])] = 0;
    }
    System.out.println(cnt);
  }
}
