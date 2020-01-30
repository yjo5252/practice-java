// epper 17_3.java

/*  입력: 숫자 n개 (stack 자료구조)
    출력: palindrome 이면 yes, 아니면 no
*/

import java.util.Scanner;
public class EPPER3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean res = true;
    Stack sta = new Stack();
    String input;
    int len, end, start;
    char[] Arr;
    char temp;

    input = sc.next();
    len = n.length();
    Arr = n.toCharArray();

    //choose stat & end
    if (len % 2 ==0){
      end = len/2-1;
      start = len/2;
    }else{
      end = len/2-1;
      start = len/2+1;
    }

    //push to stack
    for (int i=0; i<=end; i++){
      sta.push(Arr[i]);
    }

    for (int i=start; i<len; i++){
      if(!sta.isEmpty()){
        temp = (char) sta.peek();
        sta.pop();
        if(temp!=Arr[i]){
          res = false;
        }
      }
    }
    if(res==false) System.out.println("no");
    else System.out.println("yes");
  }
}
