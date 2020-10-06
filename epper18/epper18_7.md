# 2018년 7번문제 

새로 알게 된 사실 
1. 리스트에서 제외하려는 값은 -1로 변환하면 간편하다.
2.  Java Loop 쓰는 이유? for문이 여러개인 경우 탈출지점을 잡기 위해서.

### Sudo Code
```
for문 두 차례
i=0; i< count-1; i++
j = i +1 ; j < count; j++
sum -= (arr[i] + arr[j])
if (sum == 100) found = i, j; break;

나머지 출력
```

```java 
import java.util.*;
public void Q7{
  public static void main{
    Scaner sc = new Scanner(System.in);
    int arr[] = new int[9];
    int sum = 0;
    String answer ;
    for(int i=0; i<9; i++){
      arr[i] = sc.nextInt();
      sum += arr[i]; //입력값을 모두 더한다.
    }
    // 9개 중 전체 합에서 뺐을 때 100이 되는 2개의 수를 찾아 제외한다.
    Loop:
    for (i=0; i< 8; i++){
      for(j = i +1 ; j < 9; j++){
        if (sum -arr[i] - arr[j] == 100) {
           arr[i] = -1;
           arr[j] = -1;
           break loop;
          }
        }
      }
      for (int i=0; i<9; i++){
        if(arr[i]!=-1)
          System.out.print(arr[i]+" ")
      }
      System.out.println();
    }
}
```
