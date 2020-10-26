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
* [백준 1197번 문제](https://www.acmicpc.net/problem/1197)
* for 반복문에서 continue 문: while문의 {} 안에서 continue 문장을 만난 순간 continue 문 아래에 있는 실행해야 하는 문장들을 건너 뛰고, 다음 반복을 시작한다. 
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n,m;
    static int[] parent;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int result = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        
        for (int i=0; i<n; i++){
            parent[i] = i;
        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for (int i=0; i<m; i++){
            edge tmp = pq.poll();
            
            int a = find(tmp.s);
            int b = find(tmp.e);
            
            if(a == b) continue; 
            union(a,b);  // a,b 집합을 하나의 집합으로 만든다
            result += tmp.v;
        }
        System.out.println(result);
     }

      public static int find(int a){
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
      }
      
      public static void union(int a, int b){
          int aRoot = find(a);
          int bRoot = find(b);
          
          if(aRoot != bRoot){
            parent[aRoot] = b;
          } else{
              return;
          }
      }
}

// V 기준으로 Comprable을 통해 우선순위 정한다. 
class edge implements Comparable<edge>{
    int s; // start
    int e; // end 
    int v; // value (가중치)
    
    public edge (int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
    public int compareTo(edge arg0){
        return arg0.v >= this.v? -1: 1;
    }
}

class
```
### 3. 잃어버린 괄호
* [백준 1541번 문제](https://www.acmicpc.net/problem/1541)


### 4. 최단경로 
* [백준 1753번 문제](https://www.acmicpc.net/problem/1753)
