# 다이나믹 프로그래밍 (DP)
* 어떤 문제를 풀기 위해 그 문제를 더 작은 문제의 연장선으로 생각한다. 그리고 과거의 해를 활용한다
-- 목  차 --
#### 1) [가장 긴 증가하는 부분수열 : 11053번](#1-가장-긴-증가하는-부분수열)
```java
// bottom-up 
if(arr[j] < arr[i] && d[i] <= d[j])
	d[i] = d[j] + 1;
...
for (int i=1; i<=n; i++)
	max = Math.max(d[i], max);
	
```

#### 2) [가장 긴 감소하는 부분수열 : 11722번](#2-가장-긴-감소하는-부분수열)
```java
// bottom-up 
if(arr[i] < arr[j] && d[i] <= d[j]){
	d[i] = d[j]+1;
}else if (arr[i] == arr[j]){
	d[i] = d[j];	
}
...
for (int i=1; i<=n; i++)
	max = Math.max(d[i], max);	
```
#### 3) [카드 구매하기 : 11052번](#3-카드-구매하기)

```java
for (int i=1; i<=n; i++)
	for(int j =0; j<=i) j++)
		max = Math.max(d[i], p[j]+d[j-1];

```


#### 4) [연속 행렬 곱셈 순서 : 11049번](#4-연속-행렬-곱셈-순서)


#### 5) [플로이드 : 11404번](#5-플로이드)


#### 6) [파일합치기 : 11066번](#6-파일합치기)


#### 7) [LCS2 : 9252번](#7-LCS2)

(미풀이)




### 1. 가장 긴 증가하는 부분수열
* [백준 11053번 문제](https://www.acmicpc.net/problem/11053)

```java
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int d[] = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		d[0] = 1;

		for (int i = 1; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i : d) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}
}

```

### 2. 가장 긴 감소하는 부분수열 
* [백준 11722번 문제](https://www.acmicpc.net/problem/11722)
```java
import java.util.Scanner;

public class Baek11722 {
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		int d[] = new int[n+1];
		
		for (int i=1; i<= n; i++)
			arr[i] = sc.nextInt();
		
		d[1] = 1;
		
		for(int i =2; i <= n; i++){
			int d[i] =1;
			for(int j=0; j<i; j++){
				if(arr[i] < arr[j] && d[i] <= d[j]){
					d[i] = d[j]+1;
				}else if (arr[i] == arr[j]){
					d[i] = d[j];	
				}
			}
		}	
		
		int max = 0;
		
		for (int i=1; i<=n; i++)
			max = Math.max(d[i], max);
			
		System.out.println(max);
		
		sc.close();
	}
}
```

### 3. 카드 구매하기 
* 백준 11052번 문제 
* d: 최대값
* price: 카드팩의 금액 

```java
import java.util.Scanner;

public class Baek11052 {
	public static void main(String [] args){
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] price = new int[n + 1]; 
		int[] d = new int[n + 1]; 
		
		for(int i = 1; i <= n; i++){
			price[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++){
			for(int j=0; j<=i; j++){
				max = Math.max(d[i], price[j]+d[i-j]);
			}
		}
		
		System.out.println(d[n]);
		
		sc.close();

	}
}
```


### 4.연속 행렬 곱셈 순서
* [백준 11049번 문제](https://www.acmicpc.net/problem/11049)
* a[n][0] = row 값, a[n][1] = col 값 
* 동적계획값은 d[][] 2차원배열에 저장 
* 재귀를 이용해 dp[][] 배열에 저장해둔 값을 가져온다.
* 배열 선언 new
* StringTokenizer(bf.readLine()):  문자열을 지정된 구분자로 나눈다.
* Integer.parseInt():  int 형식으로 변환해준다.
* Arrays.fill(): 특정값으로 배열을 초기화할 때 유용하다.

```java
// 11049 행렬곱셈순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test{
  static int [][] a;
  static int [][] dp;

  public static int solve(int start, int end){
    if(start == end) return 0;
    if(dp[start][end] != Integer.MAX_VALUE){
        return dp[start][end];
    }
    for(int i=start; i<end; i++){
      int cost = solve(start, i) + solve(i+1, end)+ a[start][0]*a[i][1]*a[end][1];
      dp[start][end] = Math.min(dp[start][end], cost);
    }
    return dp[start][end];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    a = new int[n][2];
    dp = new int[n][n];
    
    for(int i=0; i<n; i++){
      StringTokenizer st = new StringTokenizer(bf.readLine());
      a[i][0] = Integer.parseInt(st.nextToken());
      a[i][1] = Integer.parseInt(st.nextToken());
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    System.out.println("Array filled!");
    System.out.println(solve(0, n-1));
  }

}

```
### 5. 플로이드
* [백준 11404번 문제](https://www.acmicpc.net/problem/11404)

### 6. 파일합치기
* [백준 11066번 문제](https://www.acmicpc.net/problem/11066)

### 7. LCS2 
* [백준 9252번 문제](https://www.acmicpc.net/problem/9252)

