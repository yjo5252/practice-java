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

#### 8) [내리막길 1520]
https://www.acmicpc.net/problem/1520

#### 9) [외판원 순회 2098]
https://www.acmicpc.net/problem/2098

#### 10) [볼록껍질 Convex Hull 1708]
컨벡스헐 알고리즘에 대한 공부 
https://www.acmicpc.net/problem/1708

#### 11) [팰린드롬? 10942]

https://www.acmicpc.net/problem/10942



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
* flodyWarshal: k부터 반복하는 이유. k를 거쳐가는 경로의 최단 거리를 구하기 위해서는 k-1 를 거치는 경로의 최단거리가 필요하기 때문이다. 
*  if(distance[i][j]>=INF) sb.append("0 ")": 경로가 없어서 방문하지 않음. 
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test{
  public static int cityCount;
  public static int[][] distance;
  public static final int INF = 1000000000;

  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    cityCount = Integer.parseInt(br.readLine());
    int busCount = Integer.parseInt(br.readLine());
    distance = new int[cityCount+1][cityCount+1];

    for(int i=1; i<=cityCount; i++){
      for(int j=1; j<=cityCount; j++){
        if(i==j) continue;
        distance[i][j] = INF;
      }
    }

    while(busCount-- > 0){
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      distance[start][end] = Math.min(distance[start][end], time);
    }

    flodyWarshall();
    print();
  }
  public static void flodyWarshall(){
    for(int k=1; k<=cityCount; k++){
      for(int i=1; i<=cityCount; i++){
        for(int j=1; j<=cityCount; j++){
          distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
        }
      }
    }
  }

  public static void print(){
    StringBuilder sb = new StringBuilder();
    for(int i=1; i<=cityCount; i++){
      for(int j=1; j<= cityCount; j++){
        if(distance[i][j]>=INF) sb.append("0 ");
        else sb.append(distance[i][j] + " ");
      }
      sb.append("\n");
    }
      System.out.println(sb.toString());
  }
}

```
### 6. 파일합치기
* [백준 11066번 문제](https://www.acmicpc.net/problem/11066)
* 문제: 소설의 각 장들이 수록되어있는 파일의 크기가 주어질 때, 이 파일들을 하나의 파일로 합칠 때 필요한 최소비용을 계산하는 프로그램
* 입력: T 개의 텍스트 데이터 / (각 테스트 케이스는) 소설을 구성하는 장의 수 (K의 값), 1 - K 장까지 수록한 파일의 크기를 나타내는 양의 정수 (K개)
* 알게 된 것
1. BufferedWriter
*  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	* bw.write() : 출력해준다.
	* bw.newLine(): 줄바꿈해준다.(\n 역할)
	* bw.flush(); 현재 버퍼에 저장되어있는 내용을 모두 출력한다(클라이언트에게 전달하고 버퍼를 비운다.)
	* bw.close(); 스트림을 닫는다. 
2. sum 배열: 현재 파일까지의 총합을 저장한다. sum[0]=file[0]
3. 이차원 배열 선언하는 동시에 0으로 기화된다.
4. dp배열: dp[K][K] 만큼의 이차원 배열을 선언한다. i부터 j번째까지 파일을 합치는데 필요한 비용을 넣어준다. 
	* i == j : 파일이 한 개라는 뜻이므로 0을 넣어준다. 
	* dp[i][i+1] : 인접한 두 파일의 합을 넣어준다. dp[i][i+1] = file[i] + fil[i+1]
	* i < k < j : dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + sumDist(sum, i, j))
	* sumDist(int[] sum, int start, int end)
	: 파일의 총 합을 구해놓은 sum 배열에서 , start와 end 사이의 파일들의 총 합을 구하는 함수이다. 
	3- 5번 파일의 총 합을 구해놓는다. 
i부터 j 번째까지 합치는 데 필요한 비용을 넣어준다.

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++){
      int K = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      int[] file = new int[K];
      for(int j = 0; j < K; j++){
        file[j] = Integer.parseInt(st.nextToken());
      }

      bw.write(String.valueOf(solution(file)));
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
   // sumDist(): 파일의 총합을 구하는 sum 배열에서 start&end 사이의 파일들의 총 합을 구하는 함수이다.
  static int sumDist(int[] sum, int start, int end){
    if(start == 0){
      return sum[end];
    } else{
      return sum[end] - sum[start-1];
    }
  }

  static int solution(int[] file){
    int[][] dp = new int[file.length][file.length];
    int[] sum = new int[file.length]; 

    sum[0] = file[0];

    for(int i=1; i<sum.length;i++){
      sum[i] = sum[i-1] + file[i]; // sum 배열: 현재까지의 파일의 합을 구한다. 
    }

    for(int i=0; i<file.length-1; i++){
      dp[i][i+1] = file[i] + file[i+1];  // 인접한 두 파일의 합을 넣어서 dp 배열을 초기화한다.
    }
    for(int j=2; j<file.length; j++){
      for(int i=0; i+j < file.length; i++){
        for(int k=i; k<i+j; k++){
          if(dp[i][i+j] ==0){
            dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + sumDist(sum, i, i+j);
          } else{
            dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k] + dp[k+1][i+j] + sumDist(sum, i, i+j));
          }
        }
      }
    }
  return dp[0][file.length-1];
}
}

```
### 7. LCS2 
* [백준 9252번 문제](https://www.acmicpc.net/problem/9252)
* LCS의 길이와 공통 문자열을 출력하는 문제 
* LCS (Longer Common Subsequence): 두 수열이 주어졌을 때, 모두의 부분수열이 되는 수열 중 가장 긴 것을 찾는 문제
* LCS의 길이를 구한뒤에 역추적으로 해당 수열을 출력해서 풀 수 있다.
	* LCS 배열: 길이를 구하여 저장한다. 
	* 거꾸로 추적하며 문자열을 출력한다. (연속 증가부분수열과 같은 원리) 

```java
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    char[] A = sc.next().toCharArray();
    char[] B = sc.next().toCharArray();
    int[][] LCS = new int[A.length+1][B.length+1];
    int x = A.length;
    int y = B.length;
    
    // LCS를 DP를 통해 해결한다.
    for(int i=1; i<=x; i++){
      for(int j=1; j<=y; j++){
        if(A[i-1] == B[j-1]){
          LCS[i][j] = LCS[i-1][j-1]+1;
        }
        else{
          LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        }
      }
    }

    System.out.println(LCS[x][y]);

    StringBuilder sb = new StringBuilder();
    while(!(x==0 || y ==0)){
      if(A[x-1] == B[y-1]){ // 대각선으로 이동한다. 
        sb.append(A[x-1]);
        x--;y--;
      }
      else if(LCS[x][y] == LCS[x-1][y]){ // 같은 값이 있는 곳으로 이동한다. 
        x--;
      }
      else if(LCS[x][y] == LCS[x][y-1]){ // 같은 값이 있는 곳으로 이동한다. 
        y--;
      }
    }
    System.out.println(sb.reverse().toString()); // 일치했던 문자열을 역순으로 출력한다. 
  }
}


```

// 아래의 코드는 런타임 에러가 발생했다... 왜 ? 이유 못찾음.
```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test{
  static int[][] memo = new int[1001][1001];
  static char[] str1 = new char[1001];
  static char[] str2 = new char[100];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str1 = br.readLine().toCharArray();
    str2 = br.readLine().toCharArray();
    int n = str1.length;
    int m = str2.length;

    System.out.println(getLCSLength(n,m));
    System.out.println(getLcsStr(n,m));
  }
  public static int getLCSLength(int n, int m){
    for (int i=1; i<=n; i++){
      for(int j=1; j<=m; j++){
        if(str1[i-1] == str2[i-1])
          memo[i][j] = memo[i-1][j-1] +1;
        else
          memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
      }
    }
    return memo[n][m];
  }
    public static String getLcsStr(int n, int m){
      if(n==0 || m ==0){
        return "";
      } else if(str1[n-1] == str2[m-1]) {
          return getLcsStr(n-1, m-1) + str1[n-1];
      } else{
        if(memo[n][m-1] > memo[n-1][m])
          return getLcsStr(n, m-1);
        else
          return getLcsStr(n-1, m);
      }
    }
  }


```

### 8. 내리막길 1520 
* [백준 9252번 문제](https://www.acmicpc.net/problem/1520)

### 9. 외판원 순회 2098 
* [백준 9252번 문제](https://www.acmicpc.net/problem/2098)

### 10. 볼록껍질 Convex Hull 1708 
컨벡스헐 알고리즘에 대한 공부 
* [백준 9252번 문제](https://www.acmicpc.net/problem/1708)

### 11. 팰린드롬? 10942 
* [백준 9252번 문제](https://www.acmicpc.net/problem/10942)



