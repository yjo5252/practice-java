//epper19_6.java

/*
** ���� (2020.01.23)**
1) �ϳ��� �ﰢ���� �ϳ��� �簢���� ���������.
2) ������ �ﰢ���� ���̰� ���� �ﰢ���� ������ �����̴�.
 */
import java.util.Scanner;

public class Q6 {
  public static void main(String[]args) {
    Scanner sc = new Scanner(System.in);

    int x1, y1;
    double x2, y2;
    double triangle=31250.0;//?

    x1 = sc.nextInt();
    x2 = sc.nextInt();

    //1. ���� y�� ���� �ִ� ���
    if (x1 == 0){
      // (x2,y2)�� x�� ���� �ִٰ� ����
      // x2 * y1 / 2 == 31250/0
      x2 = triangle/y1;
      y2 = 0;

      if (x2<0||x2>250){
        x2 = triangle(250-y1);
        y2 =-x2+250;
      }
    }
    else if (y1 ==0){
      y2 = tringle/x1;
      x2 = 0;
      if (y2<0||y2>250){
        y2=triangle/(250-x1);
        x2 = -y2+250;
      }
    }
    else {
        if (x1 > 12) {
          x2 = 0;
          y2 = 250-triangle/2
        }else{
          y2=0;
          x2=20-triangle/y1;
        }
      }
      System.out.printf("%.2f .2f", x2, y2);

  }
}
