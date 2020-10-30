# Greedy Algorithm 욕심쟁이 방법

-- 목  차 --
#### 1) [설탕 배달 : 2839번](#1-설탕-배달)
```java

```
#### 2) [최소스패닝트리 : 1197번](#2-최소스패닝트리)
```java

for (int i=0; i<m; i++){ //간선 개수만큼 반복한다
            edge tmp = pq.poll();
            
            int a = find(tmp.s); 
            int b = find(tmp.e); 
            
            if(a == b) continue;  
            union(a,b);  
            result += tmp.v; 
 }
 // 크루스칼의 기본 FIND 메소드: 최상위노드 찾기
 public static int find(int a){
        if(a == parent[a]) return a; //** 
        parent[a] = find(parent[a]);
        return parent[a];
      }
// 크루스칼의 기본 UNION 메소드: 간선을 채택한다.
public static void union(int a, int b){
      int aRoot = find(a);
      int bRoot = find(b);
     if(aRoot != bRoot){ //**
         parent[aRoot] = b;
     } else{
        return;
 }
 
 // V 기준으로 Comprable을 통해 우선순위 정한다. 그래야 우선순위 큐 사용 가능하다
class edge implements Comparable<edge>{
...
    public int compareTo(edge arg0){
        return arg0.v >= this.v? -1: 1;
    }
```

#### 3) [잃어버린 괄호 : 1541번](#3-잃어버린-괄호)
```java

```

#### 4) [최단 경로 : 1753번](#4-최단-경로)
```java

           private static void dijkstra(int start){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            boolean[] check = new boolean[v+1];
            queue.add(new Node(start, 0));
            dist[start] = 0;
            
            while(!queue.isEmpty()){
               Node curNode = queue.poll();
               int cur = curNode.end;
               
               if(check[cur] == true) continue;
               check[cur] = true;
               
               for (Node node: list[cur]){
                    if(dist[node.end] > dist[cur] + node.weight){
                        dis[node.end] = dist[cur] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
               }
            }     
      }
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
* 크루스칼은 간선을 중심으로. 우선순위큐를 이용해 가중치가 가장 작은 것을 고르고  싸이클이 생기지 않고 모든 노드를 방문할 수 있도록 고른다. 
1. 간선 class 만들고. 가중치에 따라 정렬되게 Comparable 설정
2. 가중치가 가장 작은 간선을 꺼낸다. (poll)
3. 시작노드와 끝 노드의 최상위 노드를 찾는다. 최상위 노드가 없다면 자기 자신이 된다.(find)
4. 최상위 노드가 다르다면 union을 통해 그 간선을 고르고 가중치를 result에 더해준다. 
5. [JAVA PriorityQueue(우선순위 큐) 클래스 사용법](https://github.com/yjo5252/practice-java/blob/master/datastructure/PriorityQueue.md)
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
        
        //시작노드와 끝노드의 최상위 노드를 찾는다. 
        // 같으면 사이클이 생기는 것이므로 지나간다. 
        // 아니면 union을 통해 그 간선을 고르고 가중치를 더해준다.
        for (int i=0; i<m; i++){ //간선 개수만큼 반복한다
            edge tmp = pq.poll();
            
            int a = find(tmp.s); 
            int b = find(tmp.e); 
            
            if(a == b) continue;  
            union(a,b);  
            result += tmp.v; 
        }
        System.out.println(result);
     }
   
   // 크루스칼의 기본 FIND 메소드: 최상위노드 찾기
      public static int find(int a){
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
      }
    // 크루스칼의 기본 UNION 메소드: 간선을 채택한다.
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

// V 기준으로 Comprable을 통해 우선순위 정한다. 그래야 우선순위 큐 사용 가능하다
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

```
### 3. 잃어버린 괄호
* [백준 1541번 문제](https://www.acmicpc.net/problem/1541)
* 적절한 괄호를 쳐서 식의 값을 최소로 만든다
* 빼는 값을 최대로 만든다. 
* split(args): 입력받은 인자를 기준으로 나누어진 String배열을 리턴
* substring(int start, int end): 이거 아님. 
```java
import java.util.Arrays;
import java.util.Scanner;

public class Q1541{
      static int min = 0;
      
      public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            
            // 첫번째 - 뺄셈 기호 앞에 있는 것들 모두 더하기 
            String[] str = input.split("-");
            min += sum(str[0].split("[+]"));
            
            for (int i = 1; i < str.length; i++){
                 min -= sum (str[i].split("[+]"));
            }
            System.out.println(min);
      }

      static int sum (String[] input){
            int result = 0;
            for (String num : input) {
                 result += Integer.parseInt(num);            
            }
            return result;
      }
}

```

### 4. 최단경로 
* [백준 1753번 문제](https://www.acmicpc.net/problem/1753)
* 다익스트라 알고리즘 : 한 노드에서 모든 노드로 가는 최단거리를 구할 수 있다. 최단거리를 저장하는 배열 + 우선순위 큐를 이용해 구현한다. 
* 요구사항: 주어진 시작점에서 다른 정점으로 가는 최단 경로를 구해라. 방향그래프. 간선의 가중치는 10이하 자연수 
* Arrays.fill(dist, INF) : 배열의 사이즈만큼 지정한 특정 값으로 한번에 초기화
* ArrayList의 add() 메소드는 인자로 전달된 객체를 리스트에 추가합니다. 
```
// 
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
```


```java
import java.io.*;
import java.util.*;

class Node implements Comparable <Node> {
      int end, weight;

      public Node (int end, int weight){
            this.end = end;
            this.weight = weight;
      }

      public int compareTo(Node o){
            return weight - o.weight;
      }
}

public class Main{
      private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      private static final int INF = 100_000_000;
      static int v, e, k;
      static List<Node>[] list;
      static int[] dist;
     
      public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(br.readLine());
           
            list = new ArrayList[v+1];
            dist = new int[v+1];
           
            Arrays.fill(dist, INF);
           
            for (int i=1; i <= v; i++){
                list[i] = new ArrayList<>();
            }
            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, weight));
            }
           
            StringBuilder sb = new StringBuilder();
            dijkstra(k);
           
            for(int i=1; i <= v; i++){
                if(dist[i] == INF) sb.append("INF\n");
                else sb.append(dist[i] + "\n");
            }
           
            bw.write(sb.toString());
            bw.close();
            br.close();
      }
      private static void dijkstra(int start){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            boolean[] check = new boolean[v+1];
            queue.add(new Node(start, 0));
            dist[start] = 0;
           
            while(!queue.isEmpty()){
               Node curNode = queue.poll(); // 가중치가 작은것부터
               int cur = curNode.end;
               
               if(check[cur] == true) continue;
               check[cur] = true;
               
               for (Node node: list[cur]){
                    if(dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
               }
            }    
      }
}
```








