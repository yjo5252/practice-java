# 2018년 8번문제 

 ```
기준점(n)을 잡고 증가시킨다. 
int: 1 / 2~4 / 5~9 / 10~16 / 17~25 
n = (int)Math.ceil(Math.sqrt(time))
n = 1 / 2 / 3 / 4 / 5
strat:  (n-1)*(n-1) 그 안의 상자만큼 이동함.

```
```java
//Q8

for (int i=0; t < T; t++){
  int time = in.nextInt();
  if(time<=0) break;
  int x = 0 ; 
  int y = 0 ;
  int n = (int)Math.ceil(Math.sqrt(time));
  int start = (n-1) * (n-1);
  
  if(n%2==0){// n이 짝수이면 오른쪽 아래로 갈수록 1 추가 
    for(int i = 1 ; i <= n; i++){
      x++; 
      start++;
      y = n; 
      if(start == time) break;
      if(start != time){
        for (int j = 1; j < n; j++){
          start++;
          x = n; 
          y--;
          if(start==time) break;          
        }
      }
      System.out.println(x+""+y);
    }
    else{//n이 홀수라면 왼쪽 위로 갈수록 1추가 
      for(int i=0; i<= n; i++){
        y++l
        start++;
        x = n; 
        if(start == time)break;
        if(start != time){
          for(int j = 1 ; j < n; j++){
            start++;
            y = n;
            x--;
            if(start == time) break;
          }
        }
        System.out.println(x+""+y);
      }
    }
  }
}
```
