# EPPER 19년도 8번 문제 

## 솔루션 1. BFS를 이용한 문제풀이 
/*
너비우선탐색 (BFS, Breadth-First Search)를 이용하여 해결한다. 
문제에서의 하루를 탐색에서의 깊이 1로 생각할 수 있으며
결국 문제는 BFS로 모든 노드를 탐색할 때의 탐색 깊이를 구하는 것이다. 
*/
```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

 class XY{
      int x,y;
      public XY(int x, int y){
          this.x = x;
          this.y = y;
      }
 }
 
 public class Q8 {
      static int [][] box = new int[1000][1000];
      static int n,m;
      static int [][] adjacent = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우 좌표
      static int n_non_fermented_tomatoes; // 안익은 토마토의 개수 
      
      static void AdjacentFerment(int x, int y, List next_q){
          // 주변 토마토를 익히고, 새롭게 익은 토마토는 다음 queue에 담기 
          for(int i=0; i<4; i++){
              int new_x = x + adjacent[i][0];
              int new_y = y + adjacent[i][1];
              
              if (check(new_x, new_y) && box[new_x][new_y] == 0){
                  box[new_y][new_x] = 1;
                  next_q.add(new XY(new_x, new_y));
                  n_non_fermented_tomatoes--;
              }
          }         
      }
      
      static boolean check (int x, int y){
            // 좌표의 유효함 확인하기 
            if (x < 0 || y < 0)
                return false;
            if (x >= n || y >= m)
                return false;
            return true;
      }
      
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            
            int temp, days = 0; 
            
            /* 
            한 번 주변에 영향을 준 토마토는, 그 이후에는 새로운 영향을 주지 않는다. 
            따라서 q1에는 어제 새롭게 익어서, 오늘 주변 토마토에 새로운 영향을 줄 가능성이 있다. 
            q2에는 q1에 있는 토마토의 영향을 받아, 오늘 새롭게 익은 토마토를 담는다 .
            */
            List<XY> q1 = new ArrayList<XY>();
            List<XY> q2 = new ArrayList<XY>();
            List temp_q;
            
            // 입력 받기 
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nexttoken());
            
            for (int y = 0 ; y < m; y++){
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x < n; x++){
                    temp = Integer.parseInt(st.nexToken());
                    boy[y][x] = temp;
                    
                    if (temp ==1)
                        //처음부터 익은 토마토는 q1에 담는다. 
                        q1.add(new XY(x,y));
                     else if (temp == 0)
                        n_non_fermented_tomatoes++;
                }
            }
            
            // 토마토 익히기 시작 
            
            while(true){
                if (n_non_fermented_tomatoes == 0) break;
                
                // q1에 있는 토마토로 주변 토마토를 익히고, 새롭게 익은 토마토는 q2에 담는다. 
                for (int i=0; i < q1.size(); i++)
                    AdjacentFerment(q1.get(i).x, q1.get(i), q2);
                 
                 // 새롭게 익은 토마토가 없다면, 토마토가 모두 익지 못하는 상황 
                 if(q2.isEmpty()) break;
                 
                 days++;
                 
                 // q2를 q1으로 옮기고, q2는 비운다. 
                 temp_q = q1;
                 q1 = q2;
                 q2 = temp_q;
                 q2.clear();
            }
            
            //결과 출력
            if(n_no_fermented_tomatoes == 0) System.out.println(days);
            else System.out.println(-1);
      }
 }     
      
      
      
 
 }
 ```
