# 백트래킹 
-- 목차 --
#### 1) [NQueens (BFS)](#1-NQueens-BFS)

#### 2) [평범한 배낭 (배낭 0-1문제)](#2-평범한-배낭-배낭-0-1문제)

#### 3) [스도쿠](#3-스도쿠)

#### 4) [단지번호붙이기 (DFS)](#4-단지번호붙이기-DFS)


#### 5) [연산자 끼워넣기]()

#### 6) [스타트와 링크]

#### 7) [NxM 조건에 맞는 사람]

#### 8) [알파벳]



### 1. NQueens BFS

* [nQueens 9663번 문제](https://www.acmicpc.net/problem/9663)
* 백트랙킹 
1. 재귀법을 사용한다. 
2. 놓은 위치가 다른 퀸으로부터 위협을 받는지를 검사하는 조건문 

```java
import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException; 

public class Main{
  public static int[]arr;  // index. 열, value 행 
  public static int N;
  public static int count = 0; 
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    
    nQueen(0);
    System.out.println(count);
    
  }

  public static void nQueen(int depth){
  // 모든 원소를 다 채웠으면 count 증가 return
    if (depth == N){
      count++;
      return;
    }
    for(int i=0; i<N; i++){
      arr[depth]=i; 
      // 놓을 수 있는 위치이면 재귀 호출
      if (Possibility(depth)){
        nQueen(depth + 1);
      }
    }
  }
  
  public static boolean Possibility(int col){
    for (int i=0; i<col; i++){
      // col열과 i열의 행값 일치 여부 
      if (arr[col] == arr[i]){
        return false;
    }
        
    // 대각선에 놓여있는 경우     
    else if (Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
      return false;
    }
  }
  return true;
  }
}
```

### 2. 평범한 배낭 배낭 0-1문제 

* [평범한 배낭 (배낭 0-1문제) 12865](https://www.acmicpc.net/problem/12865)


```java
import java.util.Scanner;

public class Main{

    static int n,k;   // 물품의 개수, 최대 무게
    static int dp[][], w[], v[]; // dp 배열, 무게, 가치 배열 
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    // 입력값 저장
    int n = sc.nextInt();
    int k = sc.nextInt();
    dp = new int[n+1][k+1]; 
    w = new int[n+1];
    v = new int[n+1];
    for (int i=1; i<=n; i++){
      w[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }
    
    /* 
      1. 이전 아이템의 총 가치 합을 복사 
      2. 한계값에서 무게를 제외한 값이 양수일 때, 
         이전 아이템 가치 합 vs 현재 아이템의 가치 + 뺀 값의 동적계획배열 가치합)
      
    */
    
    for(int i=1; i<=n; i++){
      for(int j=1; j<=k; j++){
        dp[i][j] = dp[i-1][j]; 
        if(j-w[i]>=0){
          dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
        }
      }
    }
    System.out.println(dp[n][k]);
  }
  
}
```
### 3. 스도쿠 

* [스도쿠 2580번](https://www.acmicpc.net/problem/2580)

* 일반
```
import java.util.Scanner;

public class Main{
  public static int[][] arr = new int[9][9];
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        arr[i][j] = sc.nextInt();
      }
    }
    sudoku(0,0);
  }
  
  public static void sudoku(int row, int col){
    // 해당 열이 다 채워졌으면 다음 행의 첫번째 열 호출
    if (col == 9) {
      sudoku(row+1, 0);
      return;
    }
    // 행과 열 모두 채워지면 출력 후 종료 
    if (row == 9) {
        // StringBuilder에 저장하고 출력
      StringBuilder sb = new StringBuilder(); 
      for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
          sb.append(arr[i][j]).append(' ');
        }
        sb.append('\n');
      } 
      System.out.print(sb);
      System.exit(0);
    }
  
  // if 0, check 1 ~ 9
  if(arr[row][col] == 0){
    for(int i=1; i<= 9; i++){
      if(possibility(row, col, i)){
        arr[row][col] = i;
        sudoku(row, col+1);
      }
    }
    arr[row][col] = 0; 
    return;
  }
  sudoku(row, col+1);
  }
  
  public static boolean possibility(int row, int col, int value){
    // 같은 행에 있는 원소들 중 중복 원소 검사 
    for (int i=0; i<9; i++){
      if(arr[row][i] == value){
        return false; 
      }
    } 
    
    // 같은 열에 있는 원소들 중복 검사 
    for(int i=0; i<9;i++){
      if(arr[i][col] == value) {
          return false;
      }
    }
      
    // 3*3 칸에 있는 중복 원소 검사
    int set_row = (row/3)*3; 
    int set_col = (col/3)*3;
    
    for(int i=set_row; i<set_row+3; i++){
      for(int j=set_col; j<set_col+3; j++){
        if(arr[i][j] == value){
          return false; 
        }
      }
    }
    return true; // 중복되는 것이 없으면 true 반환
  }
}

```

* 백트래킹
```
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import java.util.List;
import java.util.StringTokenizer; 

public class Main {
    public static final int size = 9;
    public static int[][] arr;
    
    public static List<int[]> list;
    public static boolean isEnd;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = null;
        
        arr = new int[size][size];
        list = new ArrayList<>();
        
        for(int i=0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] == 0) list.add(new int[] {i, j});
            }
        }
        // 입력 완료 
        backtracking(0, 0);
        
    }
    public static void backtracking(int idx, int cnt) {
        // 결과가 나왔다면 조회할 필요가 없다.
        if(isEnd) return;
        
        //빈칸에 입력된 cnt가 초기 zero 값의 cnt와 같다면 전부 입력이 된것.
        if(cnt == list.size()) {
            isEnd = true;
            print();
            return;
        }
        // 인덱스가 list크기를 넘어가면 종
        if(idx >= list.size()) return;
        
        int y = list.get(idx)[0];
        int x = list.get(idx)[1];
        
        // 1 부터 9 까지 입력 가능한 숫자 를 확인한다.
        for(int i=1; i<=9; i++) {
            // 해당 숫자가 가능하면 해당 좌표에 값을 입력하고 backtracking을 한다. 
            if(isAble(y, x, i)) {
                arr[y][x] = i;
                backtracking(idx+1, cnt+1);
                arr[y][x] = 0;
            }
        }
        
    }
    
    public static void print() {
        // 결과 출력
                StringBuilder sb = new StringBuilder();
                for(int i=0; i < size; i++) {
                    for(int j=0; j < size; j++) {
                        sb.append(arr[i][j] + " ");
                    }
                    sb.append("\n");
                }
                System.out.println(sb.toString());
    }
    public static boolean isAble(int y, int x, int v) {
        for(int i=0; i < size; i++) {
            // 가로가 유효한지 arr[y][x]의 값이 가로에 또 존재하면 안된다.
            if(arr[y][i] == v) return false;
            
            // 세로가 유효한지 arr[y][x]의 값이 세로에 또 존재하면 안된다.
            if(arr[i][x] == v) return false;
        }
        
        // 3*3이 유효한지
        int y_s = y/3 * 3;
        int x_s = x/3 * 3;
        for(int i = y_s; i < y_s+3; i++) {
            for(int j = x_s; j < x_s+3; j++) {
                if(arr[i][j] == v) return false;
            }
        }
        return true;
    }
}
```

### 4. 단지번호붙이기 DFS

* [단지번호붙이기 2667번 (DFS)](https://www.acmicpc.net/problem/2667)
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int[] goX = {-1, 0, 1, 0};
	static int[] goY = {0, 1, 0, -1};
	static int cnt;
	
	static void dfs(int N, int x, int y, int[][] map) {
		map[x][y] = 0;
		cnt++; // 집 수 증가
		
		for(int i=0; i<4; i++) {
			int nx = x + goX[i]; // 상하좌우 검사
			int ny = y + goY[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N) { // map 범위 안
				if(map[nx][ny]==1)
					dfs(N, nx, ny, map);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		int N = Integer.parseInt(br.readLine()); // 지도의 크기
		
		String strMap;
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			strMap = br.readLine(); // 지도 입력
			for(int j=0; j<N; j++) {
				map[i][j] = strMap.charAt(j) - '0'; // 0을 빼줘야 숫자가 됨
			}
		}
		br.close();
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // 오름차순이므로 우선순위 큐 선언
		
        // 탐색 시작
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					cnt = 0; // cnt 0으로 초기화
					dfs(N,i,j,map);
					
					q.add(cnt); // 탐색 횟수 저장
				}
			}
		}
		
		System.out.println(q.size());
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
```
(다음턴에 도전) 연산자 끼워넣기 14888번


### 5. 연산자 끼워넣기 

* [연산자 끼워넣기 14888](https://www.acmicpc.net/problem/14888)

### 6. 스타트와 링크

* [스타트와 링크 14889](https://www.acmicpc.net/problem/14889)

### 7. N x M 조건에 맞는 사람 

* [조건에 맞는 사람 12번 15666](https://www.acmicpc.net/problem/15666)

### 8. 알파벳  

* [알파벳 1987](https://www.acmicpc.net/problem/1987)
