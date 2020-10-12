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
* 배열의 크기를 최소 사이즈가 2가 될때까지 계속 4등분하면서 입력받은 좌표가 범위 안에 있는 것들만 계산한다.
* 방문순서는 왼쪽 위칸, 오르쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸
* 찾는 좌표가 어느 분면에 속하는지 알아내면 문제를 해결할 수 있다 
- 3분면에 속한다는 의미는 1,2분면을 방문했다는 것을 의미하므로 1,2분면의 방문한 수를 더해주면 된다
- 3분면안에서 다시 4등분한다
* 현재위치(x,y)를 (r,c)와 비교하며 영역을 찾아간다. 
* 예를 들어 8 * 8 배열을 4등분하고 최소 사이즈가 됐을 때 방문 횟수를 계산해서 출력한다.

```java
import java.util.Scanner;


public class Main{
   
   public static int row;
   public static int col;
   
   public static int[] dy = {0, 0, 1, 1};
   public static int[] dx = {0, 1, 0, 1};
   public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int pow = sc.nextInt();
     
     int size = (int) Math.pow(2, pow);
     row = sc.nextInt();
     col = sc.nextInt();
     
     drawZ(0, 0, 0, size);     
   
     sc.close();
     
     System.out.println(size*size);
   }
   
   public static void drawZ(int y, int x, int cnt, int size){
    // 확인하는 row와 col의 좌표가 y <= row < y+size, x <= col < x+size의 범위에 해당하지 않으면 구할 필요 없다. 
    if(y > row || y+size <= row || x > col || x+size <= col ) return;

    if(size == 2){
      for (int i=0 ; i < 4; i++){
         int yy = dy[i] + y;
         int xx = dx[i] + x;

         if(yy == row && xx == col)System.out.println(cnt + i);
      }
      return;
    }

    int newSize = size/2;
    //if(row <y+newSize && col < x+newSize)
      drawZ(y, x, cnt, newSize); // 왼쪽 위
    
    //if(row < y+newSize && col >= x+newSize)
      drawZ(y, x+newSize, cnt+(newSize*newSize), newSize); // 오른쪽 위, 횟수 1 추가  

    //if(row >= y+newSize && col < x+newSize)
      drawZ(y+newSize, x, cnt+(newSize*newSize)*2, newSize); // 왼쪽 아래, 횟수 2추가

   // if(row >= y+newSize && col >= x + newSize)
      drawZ(y+newSize, x+newSize, cnt+(newSize*newSize)*3, newSize); // 오른쪽 아래, 횟수 3추가
   }
}
```


















