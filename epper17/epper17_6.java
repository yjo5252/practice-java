// epper 17_6.java

/*  �Է�: ���� ���� A�� �Է��Ѵ�.
    ���: ��� �ڸ����� �����ϰ� �Ǵ� ���� A�� ���� ������ n�� ���
*/
import java.util.*;


public class EPPER6 {
  public static boolean checkN(int[] a){
    //�迭�� 0�� ����ִ� �� Ȯ���ϴ� �Լ� (��� 0�̵ɶ����� �ݺ�)
    for (int i=0; i<=9; i++){
      if (a[i]!=0) return false;
      }return true;
  }
  //main �Լ�
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int Nnum=0, num=0, cnt=0;
    String temp;
    char [] charArr;

    //�迭 ���� �� �ʱ�ȭ
    int arr[] = new int[11];
    for (int i=0; i<11; i++) arr[i] = 1;

    //�ʱ� �ԷµǴ� ������
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
