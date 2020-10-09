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
