// epper 18_3.java

/*  �Է�: ���� ���ĺ� (������(-)���� ����)
    ���: �빮�ڷ� ������ ��๮
*/

import java.util.*;
public class EPPER3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    //��ū ���� �ڵ�
    //"str"�� �ڸ���. "-"�� ��������. false option: "-"����.
    StringTokenizer st = StringTokenizer(str,"-",false);

    while (st.hasMostTokens()){//��ū�� �������� ������ �ݺ�
      System.out.println(st.nextToken().charAt(0)); ///��ū�� ù ����
    }
    System.out.println(); //�ٹٲ� ����Ʈ 
    }
}
