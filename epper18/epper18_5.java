// epper 18_5.java

/*  �Է�: 8�� ���� (���� ����)
    ���: ascending, descending, mixed �Ǵ�
*/

import java.util.*;
public class EPPER5 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    //���� ����
    String asc = "1 2 3 4 5 6 7 8"; //ascending�� ���ڿ�
    String desc = "8 7 6 5 4 3 2 1"; //descending�� ���ڿ�
    //���ڿ� �Է�
    String str = sc.next();

    if (asc.equals(str)) System.out.println("ascending");
    else if (desc.equals(str)) System.out.println("descending");
    else System.out.println("mixed");

    }
}
