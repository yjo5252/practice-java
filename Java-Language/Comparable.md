# Comparable 

객체를 정렬할 때 사용하는 `Comparable`

## Comparable 인터페이스

* 정렬 수행 시 사용되는 메서드, 정렬 기준이 되는 메서드를 정의하는 인터페이스이다. 
* 추상 메서드 `compareTo()`를 구현해야 한다. 비교하려는 대상 객체를 매개변수로 넘겨준다. 
* 비교 대상이 동일한 값일 경우0, 작은 경우 -1, 큰 경우 1을 반환한다. 
```java
class Node implements Comparable <Node> {
      int end, weight;

      public Node (int end, int weight){
            this.end = end;
            this.weight = weight;
      }
      @override
      public int compareTo(Node o){
            return weight - o.weight;
      }
}

```
