/*
* 기사 R행, C열 ==> ZR행, ZC 열로 확대하여 출력하는 프로그램 
* 
*/
import java.util.Scanner;

public class epper19_7{

   public static void main(String[] args){

      Scanner sc = new Scanner(System.in);
      int r, c, zr, zc;
      r = sc.nextInt();
      c = sc.nextInt();
      zr = sc.nextInt();
      zc = sc.nextInt();
      String[] init = new String[r]; // 기존 행렬 저장
      String[] result = new String[r * zr]; // 확대된 행렬 저장 

      for (int i = 0 ; i < r; i++){
          init[i] = sc.next();
      }
      int count = 0;
      for (int i = 0; i < r; i++){
          String temp = "";
          for(int j = 0; j < init[i].length(); j++){
              char ch = init[i].charAt(j);
              for(int k = 0; k < zc; k++) // 가로로 확대
                  temp += ch;
          }
          for(int k = 0 ; k < zr; k++){ // 세로로 확대하여 저장 
                result[count++] = temp;
           }
      }
      return result;     
    }
}
