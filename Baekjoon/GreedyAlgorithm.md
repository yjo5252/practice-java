# Greedy Algorithm 욕심쟁이 방법

-- 목  차 --
#### 1) [설탕 배달 : 2839번](#1-설탕-배달)
```java

```
#### 2) [최소스패닝트리 : 1197번](#2-최소스패닝트리)
```java

```

#### 3) [잃어버린 괄호 : 1541번](#3-잃어버린-괄호)
```java

```

#### 4) [최단 경로 : 1753번](#4-최단-경로)
```java

```


### 1. 설탕 배달
* [백준 2839번 문제](https://www.acmicpc.net/problem/2839)
* 5로 최대로 나누어보고 안 나누어질때까지 하나씩 줄여가며 3을 채워나간다. 
```java
public static void main(String[] args){
    int input = 0; 
    int count = 0;
    Scanner sc = new Scanner(System.in);
    input = sc.nesxtInt();
    
    while (true) {
       if(input %5 == 0){
          System.out.println(input/5 + count);
          break;
       } else if(input <= 0) { //정확히 N킬로그램을 만들 수 없는 경우
          System.out.println(-1);
          break;
       }
       input = input -3; 
       count++;
    }
}
```
### 2. 최소스패닝트리


### 3. 잃어버린 괄호

### 4. 최단경로 
