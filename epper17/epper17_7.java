// epper 17_7.java

/*  �Է�: ���� ���� (m) x ���� ���� (n)
          m�ٿ� ���� ���ڰ� �ִ°� (*), ���� �� (-) ǥ��
    ���: ���� �ִ� �� + ��濡 ��ġ�� ������ ����
*/
import java.util.*;


public class EPPER7 {
  static int landmine[][];


  //checksum �Լ�
  public static int checksum(int i, int j){
    int sum = 0;
    if (landmine[i][j] == -1) return -1;
    for (int x = i-1; x <= i+1; x++){
      for (int y = j-1 ; y <= j+1; y++){
        sum += landmine[x][y];
      }
    }
  }return sum;

  //main �Լ�
  public static void main(String[] args){

    Scanner sc = new Scanner();
    int  row=0, col=0;
    int result[][];

    row = sc.nextInt();
    col = sc.nextInt();

    sc.nextLine(); //���� ����
    landmine = new int[m+2][n+2];
    result = new int[m][n];

    for(int i=1; i<=row; i++){
      String inputLine = sc.nextLine();
      for(int j=1; j<=col; j++){
        if (inputLine.charArray(j-1) == '*'){
          landmine[i][j] = 1;
        } else landmine[i][j] = 0;
      }
    }
    for(int i=1; i<= row; i++){
      for(int j=1; j <=col; j++){
        result [i-1][j-1] = checksum(i,j);
      }
    }
    for (int i=0; i<row; i++){
      for (int j=0; j<col; j++){
        if(result[i][j]!=-1) System.out.print(result[i][j]);
        else System.out.print('*');
      }
    }System.out.println();

    return sum ;
  }
