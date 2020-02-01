// epper 17_4.java

/*  입력: 지불 비용 C, 물건 비용 M
    출력: 거스름돈 동전의 수
*/

import java.util.Scanner;
public class EPPER4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int toal, price, change;
    int coin[] = {500,100,50,10,5,1};
    int count = 0;

    total = sc.nextInt();
    price = sc.nextInt();
    change = total-price;
    for(int i=0; i<6; i++){
      count += change/coin[i];
      change = change % coin[i];
    }

    System.out.println(count);
  }
}
