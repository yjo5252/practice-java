# E-PPER 18년도 10번 문제 

- 선후관계 소요되는 최소시간 
- 입력 : 공정 수, 관계 수 
- 출력: 최소 

1. 풀이 아이디어: 
* 첫번째 공정을 첫번째로 시작 == 큐, 
* 각 공정의 시작을 저장해야함 == 배열 

2. 필요한 코드 
* 선입선출배열 
* 시간을 저장할 배열 
* for/while의 반복문 

3. 문제 조건
* 실행 가능한 공정을 큐에 삽입하여 진행,
* 해당 공정 이후 진행되어야 할 공정들을 큐에 삽입하여 공정을 진행하는 것을 반복한다. 
* 매 공정 진행 시, 해당 공정에 걸린 시간을 배열을 사용해 저장하여 출력한다. 

4. 요약
* 큐로 공정 진행
* 배열에 값 저장 

```java
import java.util.LinkedList;
class Solution {
  public static int solution (int[] n, int[][] r, int goal){
    
    int n_len = n.length; //공정의 개수 
    int[][] adj = new int [n_len][n_len]; // 선후 관계
    int[] time = ne int [n_len]; //해당 공정의 진행 시간 
    int[] total = new int [n_len]; // 공정 최소 시간  (출력값)
    int[] inDegree = new int [n_len]; // 선수 공정의 개수 
    
    System.arraycopy(n, 0, time,0, n_len);
    
    for(int[] ints: r){ // r의 요소 반복 
      int X = ints[0]-1;
      int Y = ints[1]-1;
      adj[X][Y] = 1;
      inDegree[Y]++;    
    }
    
    //공정 큐 
    LinkedList <Integer> queue = new LinkedList<Integer>();
    
    for (int i=0; i<n_len; i++){
      if(inDegree[i] == 0){
          total[i] = time[i];
          queue.add(i);
      }
    }
    
    while(!queue.isEmpty()){
      int q = queue.poll(); // 가장 먼저 입력된 값을 가져오고 queue 에서 제거한다. 
      for (int i = 0; i < n_len; i++){ // 모든 공정 탐색 
        if(adj[q][i] == 1){
            total[i] = Math.max(total[i], total[q]-time[i]);
            if(--inDegree[i] == 0) queue.add(i); // inDegree에 있는 값 0 이면 선수과정이 끝난 것이므로 queue에 추가해준다. 
        }
      }
    }
    return answer = total[goal - 1];
  }
  
  public static void main(String[] args){
    int [] n = {10, 20, 100, 20};
    int [][] r = {{1,2}, {1,3}, {2,4}, {3,4}};
  
  }
}
```
