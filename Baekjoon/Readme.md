# 백준


## 1. 분할정복법 
### 풀이법 재귀 divide(), check() 
```java
// check
int std = map[row][col] ;
for (int i = row; i < row + n; i++) {
    for (int j = col; j < col + n; j++) {
        if (std != map[i][j])
            return false;
    }
}
return true;
```
```java
// divide
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
```
### 문제 리스트 
* 쿼드트리 : 1992번
* 종이의 개수 : 1780번

## 2. 동적계획법 (DP)
#### 속성 
1. Overlapping Surproblem (부분 문제가 겹친다) 
2. Optimal Substructure (최적 부분 구조)

#### 풀이 방법 
1. Top-down 
- 큰 문제를 작은 문제로 나눈다. F(n-1), F(n-2)
- 작은 문제를 푼다. F(n-1)+F(n-2)
- 재귀 호출을 하는 방식으로 푼다. 
```java
fibonacci(n){
  if(n<=1) return n;
  else if (n <= 2) return 1;
  else {
    if(memo[n]>0) return memo[n[;
    memo[n] = fibonacci(n-1)+fibonnacci(n-2);
    return memo[n];
  }
}
```

2. Bottum-up
- 문제를 크기가 작은 문제부터 차례대로 쓴다. 
- 문제의 크기를 조금씩 크게 만들면서 문제를 푼다. 
- 작은 문제를 풀면서 큰 문제의 답을 구한다.
```java
int d[100];
fibonacci(int n){
  d[0] = 0;
  d[1] = 1;
  for (int i = 2; i<= n; i++){
    d[i] = d[i-1] + d[i-2];
  }
  return d[n];
}
```
### 문제 리스트 

* 가장 긴 증가하는 부분수열 : 11053번 
* 가장 긴 감소하는 부분 수열 : 11722번
* 카드 구매하기 : 11052번

## 3. 탐색 (BFS & DFS)
### 1. 깊이 우선 탐색 (DFS) 
    * 해당 분기를 완벽하게 탐색하는 방법
    * 모든 노드를 방문하고자 하는 경우 
    * 미로 탐색 (막히면 다시 가장 가까운 갈림길로 돌아가 풀이 진행)
    * 경로의 특징을 방문해둬야 하는 경우 (ab 경로에 같은 숫자가 있으면 안된다 등)
    * 검색 대상 그래프가 정말 크다면 DFS를 고려
    * 저장된 값 출력 

* 풀이 방식 : <br>
    * (1) 재귀 함수 호출 (짧은 코드 길이 보장) 
        * 전체 탐색 후 출력 
        * 방문한 노드 visted[]
    * (2) 스택 
       
### 2. 높이 우선 탐색 (BFS)
    * 두 노드간의 최단 경로를 찾고 싶을 때 사용하는 방법 
    * 가장 근접한 노드부터 탐색 (BFS는 먼저 찾아지는 겨웅가 해답이다)
    * 조건에 만족하는 것 출력
* 풀이 방식 : 새로운 배열에 update, 바로 값 출력하기도
    * 방문한 노드 visited[] 
    * 큐를 이용한 탐색 (poll(), add()) 
    * 우선순위 큐를 이용한 탐색 ( priority queue, class 새로 정의하기도.. implements Comparable - compareTo(), poll(), add())
    
* 양식 
백준 (번호) 제목.md 
1. 문제 
2. 풀이방법 
3. Java문법 /자료구조
4. 코드



