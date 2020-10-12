# 분할정복법 


#### 1) [쿼드트리 : 1992번](#1-쿼드트리)
```java
s = n/2; 
```
#### 2) [종이의 개수 : 1780번](#2-종이의-개수)
```java
int std = map[row][col] ;
s = n/3;
divide(row+s*i, col+s*j, s);
```

### 3) [Z: 1074](#3-Z)
```java
```


### 1. 쿼드트리
* [백준 1992번 문제](https://www.acmicpc.net/problem/1992) 
* 복잡한 문제를 작은 단위로 나눠서 처리한 후 합친다. 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class beak_1992 {
    private static int n, m;
    private static int map[][];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
 
        map = new int[n][n];
        int[] num = new int[n];
 
        for (int i = 0; i < n; i++) {
            String num_1 = br.readLine();
            for (int j = 0; j < n; j++) {
                num[j] = num_1.charAt(j);
                map[i][j] = (int)num[j] - 48;
            }
        }
        divide(0, 0, n);
    }
 
    private static boolean check(int row, int col, int n) {
        int std = map[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (std != map[i][j]) {
                    return false;
                }
            }
        }
        m = std;
        return true;
    }
 
    private static void divide(int row, int col, int n) {
        if (check(row, col, n)) {
            System.out.print(m);
        } else {
            System.out.print("(");
            int s = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divide(row + s * i, col + s * j, s);
                }
            }
            System.out.print(")");
        }
    }
}

```

### 2. 종이의 개수 
* [백준 1780번 문제](https://www.acmicpc.net/problem/1780)
* 먼저 입력을 받고 divide 함수에서 재귀적으로 동작한 후 if문을 두어 원소가 0또는 1이면 빠져나오게 한다. 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class beak_1780 {
    private static int n;
    private static int map[][];
    private static int[] count = new int[3];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
 
        map = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        divide(0, 0, n);
        
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
 
    private static boolean check(int row, int col, int n) {
        int std = map[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (std != map[i][j])
                    return false;
            }
        }
        return true;
    }
 
    private static void divide(int row, int col, int n) {
        if (check(row, col, n)) {
            count[map[row][col]+1]++;
        } else {
            int s = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + s * i, col + s * j, s);
                }
            }
        }
    }
}

```

### 3. Z 
* [백준 1074번 문제](https://www.acmicpc.net/problem/1074)
* 문제: 배열의 크기를 최소 사이즈가 2가 될때까지 계속 4등분하면서 입력받은 좌표가 범위 안에 있는 것들만 계산한다. 방문순서는 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸

* 풀이법: 분할정복 & 재귀호출 
* 찾는 좌표가 어느 분면에 속하는지 알아내면 부분적으로 크기를 구해 문제를 해결할 수 있다 
- 3분면에 속한다는 의미는 1,2분면을 방문했다는 것을 의미하므로 1,2분면의 방문한 수를 더해주면 된다
- 3분면안에서 다시 4등분한다.
- (7,7)에 위치한다면 사이즈가 64인 사각형에서 3/4만큼은 확정이다.
- 48 + 12 + ... 해당 사각형의 번호를 구한다.

* 방문횟수를 출력한다.

* 복잡도 / 타입 크기 주의
- 한 배열의 크기는 2^n, 쪼개진 배열의 크기는 2^(n-1)
- N <= 15, 2차원 배열이므로 최대배열이 나타낼 수 있는 숫자는 2 ^ 30 
- Integer 타입의 크기는 4 Byte, 2^32의 메모리차지하므로 int 타입만으로도 풀 수 있다. 

```java

import java.io.*;
import java.util.StringTokenizer;


public class Main{
   public static int count = 0; 
   
   public static void main(String[] args)throws IOException{
   
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     StringTokenizer st = new StringTokenizer(br.readLine());
     
     int N = Integer.parseInt(st.nextToken());
     int r = Integer.parseInt(st.nextToken());
     int c = Integer.parseInt(st.nextToken());
     
     divide(N, c, r);
     System.out.println(count);
   }
   
   public static void divide(int n, int x, int y){
   
    if (n == 0){
      return;
    }

    int len = (int) Math.pow(2, n);
    int size = len * len;
    int partLen = len / 2; // 2^(n-1)
    
    if (x < partLen && y < partLen){ // 왼쪽 위
       divide(n-1, x, y);
    } else if (partLen >= x && y < partLen){//오른쪽 위
       count += (size/4);
       divide(n-1, x-partLen, y);
    }else if (x < partLen && partLen <= y){ // 왼쪽 아래
       count += (size/4) * 2;
       divide(n-1, x, y-partLen);
    }else if (partLen <= x && partLen <= y){ // 오른쪽 아래 
       count += (size/4) * 3;
       divide(n-1, x-partLen, y-partLen);
    }
  }
}
```


















