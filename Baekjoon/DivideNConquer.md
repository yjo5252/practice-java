# 분할정복법 


#### 1) [쿼드트리 : 1992번](#1-쿼드트리)
```ja
s = n/2; 
```
#### 2) [종이의 개수 : 1780번](#2-종이의-개수)
```java
int std = map[row][col] ;
s = n/3;
divide(row+s*i, col+s*j, s);
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
