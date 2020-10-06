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
