# 코딩테스트 -  정렬

정렬을 이용해서 문제를 효율적으로 풀어보세요.

[프로그래머스>정렬](https://programmers.co.kr/learn/courses/30/parts/12198)

## 문제
### 문제. [K번째수](#K번째수) 
#### 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

#### 제한사항
* array의 길이는 1 이상 100 이하입니다.
* array의 각 원소는 1 이상 100 이하입니다.
* commands의 길이는 1 이상 50 이하입니다.
* commands의 각 원소는 길이가 3입니다.

#### 입출력 예
```
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
```
#### 입출력 예 설명

[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.

[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.

[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.


### 문제. [가장 큰 수](#가장큰수) 
#### 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

#### 제한 사항
* numbers의 길이는 1 이상 100,000 이하입니다.
* numbers의 원소는 0 이상 1,000 이하입니다.
* 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

#### 입출력 예
```
numbers	return
[6, 10, 2]	6210
[3, 30, 34, 5, 9]	9534330
```

### 문제. [H-Index](#H-Index) 
#### 문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

#### 제한사항
* 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
* 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
#### 입출력 예
```
citations	return
[3, 0, 6, 1, 5]	3
```
#### 입출력 예 설명
이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

## 코드 
### K번째수
```java
// case1
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length] ;
        int start =0, end = 0, target = 0;
        int[] temp = {};
        for (int i=0; i < commands.length; i++){
            start = commands[i][0]-1;
            end = commands[i][1];
            target = commands[i][2]-1;
            temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            answer[i] = temp[target];
        }
        
        
        return answer;
    }
}
``` 

```java
//case 2
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length] ;
       
        for (int i=0; i < commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int target = commands[i][2]-1;
            
            int [] temp = new int[end-start]; //[] 
            int a = 0;
            for (int j = start; j < end ; j++) //copyOfRange 대신
                temp[a++]= array[j];
           
            Arrays.sort(temp);
            answer[i] = temp[target];
        }
        
        
        return answer;
    }
}

```
### 가장큰수
```java

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        //int 배열을 String 배열로 변환 
        String [] arr = new String[numbers.length];
        for (int i = 0 ; i < numbers.length; i++){
            arr[i] = (String.valueOf(numbers[i]));
        }
        
        //comparator 배열 정렬 재정의.정렬 규칙으로 2개를 더하여 더 큰 쪽이 우선순위가 되도록 정렬한다. 
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        // 예외처리 : 0000을 0로 출력
        if (arr[0].equals("0")) return "0";
        
        // 그 외의 경우 순차적으로 answers return 
        for (int i = 0 ; i < arr.length; i++){
            answer += arr[i];
        }
        
        return answer;
    }
}

```
### H-Index
```java
//case1
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++){
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h; 
                break;
            }
        }
        
        return answer;
    }
}
```
```java
//case 2 

// h번 이상 인용된 논문이 h편 이상인 h의 최대값
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int[] citations) {
        Integer [] cArr = new Integer[citations.length];
        for (int i = 0 ; i < citations.length; i++){
            cArr[i] = citations[i];
        }
        Arrays.sort(cArr, Collections.reverseOrder());
        for (int i = 0; i < citations.length; i++){
            if (cArr[i] < i+1){
                return i;
            }
        }
        return citations.length;
    }
}
```
