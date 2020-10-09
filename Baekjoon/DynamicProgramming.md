# 다이나믹 프로그래밍 (DP)

### 1. 가장 긴 증가하는 부분수열
* 백준 11053번 문제 

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

### 2. 가장 긴 감소하는 부분 수열 
* 11722
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
		
		for(int i =2; i < n; i++){
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
```java
import java.util.Scanner;

public class Baek11052 {
	public static void main(String [] args){
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] p = new int[n + 1];
		int[] d = new int[n + 1];
		
		for(int i = 1; i <= n; i++){
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++){
			for(int j=0; j<=i; j++){
				max = Math.max(d[i], p[j]+d[i-j];
			}
		}
		
		System.out.println(d[n]);
		
		sc.close();

	}
}
```




