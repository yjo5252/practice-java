# 우선순위 큐 (Priority Queue)

```java
import java.util.PriorityQueue;

// int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

// int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

// String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>();

// String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

```
1. java.util.PriorityQueue 라이브러리를 추가한다. 
2. Queue<Element> queue = new Queue<>() 와 같은 형식으로 선언한다. 
* 옵션: 
    * 기본: 우선순위가 낮은 숫자가 부여된다 (작은게 최상위 노드)
    * Collections.reverseOrder() 메소드: 높은 숫자가 우선순위가 된다

### PriorityQueue 값 추가 
```
priorityQueue.add(1);
priorityQueue.add(2);
priorityQueue.add(3);
```
### PriorityQueue 값 삭제
```
priorityQueue.poll(); // 첫번째 값 반환하고 비어있다면 null
priorityQueue.remove(); // 첫번째 값 제거 
priorityQueue.clear(); // 초기화
```

### PriorityQueue 에서 우선순위가 가장 높은 값 출력
```
PriorityQueue.peek();

```
