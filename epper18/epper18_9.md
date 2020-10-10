# EPPER 2018년 9번 문제 

### 풀이법 1. 모든 경우의 수를 따져서 문제를 풀이한다. 
```
w,  h-2 , 
w, h-1, w-2
w, h-1, w-1, h-2

w (나머지+1), h-1
w (나머지+1), h-2, h

w-2, h
```

```java
// Q9
import java.util.*;
public class Q9{
  public static void main(String[] args){
    Scanner sc = new Sacnner(System.in);
    int w = sc.nextInt(); // 가로 
    int h = sc.nextInt(); // 세로 
    int min = Math.min(w,h); //p의 길이는 min을 넘을 수 없다. 
    int total = w*h;
    if(w!=1 && h!= 1){
      total -= (w-2)*(h-2);
    }
    for(int i=1; i<min; i++ ){
      if(i==1){
        System.out.print("1");
        continue;
      }
      // 테두리의 총타일수가 나누어떨어져야지만 덮을 수 있다. 
      if(total%i ==0){
        if(w%i==0){ 가로를 다 채운 경우 
          if((h-2)%i==0){
            System.out.println(i+" ");
            continue();
          }
          else if((h-1)%i==0){
            if((w-2)%i==0){
              System.out.println(i+" ");
              continue();
            }
            else if((w-1)%i==0 && (h-2)%i==0){
              System.out.println(i+" ");
              continue();
            }
          }
        }
        else if(w%i==1){// 가로의 맨 끝에 하나가 남는다.
          if((h-1)%i==0){
            System.out.println(i+" ");
            continue();
          }
          else if((m-2)%i==0 && m%i ==0){
            System.out.println(i+" ");
            continue();
          }
        }
        else if(n-2%i==0){//가로의 양쪽이 남는 경우 
          if(m%i==0){
            System.out.println(i+" ");
            continue();
          }
        }
      }
    }
  }
}
```
### 풀이법 2. 새로운 값을 추가해서 풀이한다. 
n x m 크기의 정렬 바닥에 타일을 붙인다. 
가능한 p를 출력한다. 

풀이 아디이어: 가능한 P를 구하는 것이기 때문에 일정횟수를 반복하여 가능한지를 확인하는 방법
필요한 코드: for문/else if 를 사용하여 풀이한다. 
문제조건: 먼저 정원의 테두리에만 붙이기 때문에 테두리만의 크기를 계산한다. 
가장 긴 타일의 길이를 정원의 크기를 고려하여 알아내고, 해당 횟수만큼 반복하여 각 P가 가능한지 확인한다. 
```java
class Solution{
  public static int[] solution(int n, int m) {
    int[] answer = {};
    int min = Math.min(n,m);
    answer = new int[min+1];
    
    int total = n*m; //정원의 테두리의 크기 
    if(n != 1 && m != 1)
      total -= (m-2)*(n-2);
     
     int j = 0; 
     for (int i = 1; i<= min; i++){
        if (i == 1){ // 1 * 1
            answer[j++] = 1;
            continue;
        }
        if (total % i ==0){
          if(n % i == 0){ //p가 n을 나머지 없이 나눌 수 있는 경우 
            if((m-2)%i==0) answer[j++] = i; // p가 m-2를 나머지 없이 나눌 수 있는 경우
            else if ((m-1)%i==0 && (n-2)%i==0) //p가 m-1을 나머지 없이 나눌 수 있는 경우, n-2를 나머지 없이 나눌 수 있는 경우 
              answer [j++] = i;
          } esle if(n%i == 1){ //p가 n을 나머지 1을 남기고 
              if((m-1)%i == 0) answer[j++] = i; //p가 m-1을 나머지 없이 나눌 수 있는 경우 
              else if ((m-2) % i == 0 && m % i == 0) answer[j++] = i; // p가 m-2를 나머지 없이 나눌 수 있는 경우, m을 나머지 없이 나눌 수 있는 경우 
          } else if (n % i == 0 && (n-2) % i == 0) answer[j++] = i; // p가 n을 나머지 없이 나눌 수 있는 경우, n-2를 나머지 없이 나눌 수 있는 경우 
        }
     }
     return answer;
  }
  
  public static void main(String[] args){
  
  
  }
}
```






