//epper19_6.java

/*
** 참고 (2020.01.23)**
1) 하나의 삼각형과 하나의 사각형이 만들어진다.
2) 생성된 삼각형의 넓이가 원래 삼각형의 넓이의 절반이다.
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

    //1. 점이 y축 위에 있는 경우
    if (x1 == 0){
      // (x2,y2)가 x축 위에 있다고 가정
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
