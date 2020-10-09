# 다이나믹 프로그래밍 (DP)

### 가장 긴 증가하는 부분수열
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
