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
    y1 = sc.nextInt();

    //점이 y축 위에 있는 경우
    if (x1 == 0){
      // (x2,y2)가 x축 위에 있다고 가정하고 좌표 계산
      // x2 * y1 / 2 == 31250/2
      x2 = triangle/y1;
      y2 = 0;
      // 계산된 점의 좌표가 삼각형의 선분위가 아니라면 점2가 삼각형의 빗변위에 있음
      if (x2<0||x2>250){
        x2 = triangle/(250-y1); 
        y2 =-x2+250;   // x + y = 250 직선방정식 위의 (X2,y2)
      }
    }
    // 점이 x축 위에 있는 경우 
    else if (y1 ==0){
      // (x2,y2)가 y축 위에 있다고 가정하고 좌표 계산
      y2 = tringle/x1;
      x2 = 0;
      // 계산된 점의 좌표가 삼각형의 선분위가 아니라면 점2가 삼각형의 빗변위에 있음
      if (y2<0||y2>250){
        y2=triangle/(250-x1);
        x2 = -y2+250;
      }
    }
    else {
        if (x1 > 125) { // 선분이 Y축을 가로지름
          x2 = 0;
          y2 = 250-triangle/x1;
        }else{ // 선분이 X축을 가로지름 
          y2=0;
          x2=250-triangle/y1;
        }
      }
      System.out.printf("%.2f .2f", x2, y2);

  }
}
