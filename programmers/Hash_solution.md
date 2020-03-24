## 코딩테스트 연습 > 해시 
### 1.  문제: 완주하지 못한 선수
https://programmers.co.kr/learn/courses/30/lessons/42576 
// 자바 Hash 사용
```java
import java.util.HashMap;

public class Solution {
  public String solution (String[] participant, String[] completion){
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    int i=0;
    for (String p: participant){
      if(!hm.containsKey(p)){
            hm.put(p,1);
      }
      else{
            hm.replace(p,hm.get(p)+1);
      }
    }
    for (String c: completion){
      if(hm.containsKey(str2)){
            hm.put(c, hm.get(c)-1);
      }
    }
    String answer = "";
    for (String s : map.keySet()){
      if(hm.get(s) == 1){
            answer = s;
            break;
      }
    }
    return answer;
  }

}

```
### 2. 전화번호부 목록 
https://programmers.co.kr/learn/courses/30/lessons/42577

```java
class Solution {
  public boolean solution (String[] phone_book){
    for (int i =0; i < phone_book.length-1; i++){
        for (int j=i+1; j < phone_book.length; j++){
          if (phone_book[i].startsWith(phone_book[j])) {return false;}
          if (phone_book[j].startsWith(phone_book[i])) {return false;}
      }
    } return true;
  }
}
``` 

### 3. 완주 
https://programmers.co.kr/learn/courses/30/lessons/42578
```java
import java.util.HashMap;
import java.util.Iterator;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap <String, Integer> map = new HashMap<>(); // categories <categoreisName, #>
        for (int i = 0; i < clothes.length; i++) {
          String categoriesName = clothes[i][1];
          if(!map.containsKey(categoriesName)){
            map.put(categoriesName, 1); // 신규 의상종류 1개
          } else {
            map.replace(categoriesName,map.get(categoriesName)+1 ); // 기존 의상 종류 1개 추가
          }
        }
        Iterator <Integer> it = map.values().iterator();
        while(it.hasNext()){
          answer *= it.next().intValue() + 1;
        }
        return answer -1;
    }
}
```



4. 베스트 앨범 
```java

import java.util.*;
class Solution {
    public int[] solution(String[] genres, Integer[] plays) {
        // <고유번호, 플레이 횟수> <고유번호, 장르>
        HashMap <Integer, Integer> playMap = new HashMap<Integer, Integer>();
        HashMap <Integer, String> genreMap = new HashMap <Integer, String>();
        for (int i = 0; i < genres.length; i++) {
          playMap.put(i, plays[i]);
          genreMap.put(i, genres[i]);
        }

        // 장르의 종류 뽑는다.
        HashSet<String> gSet  = new HashSet<String>();
        for (int i = 0; i < genres.length; i++) {
          gSet.add(genres[i]);
        }

        // 장르별 총 플레이 횟수 계산 < 플레이 횟수, 장르> hashmap
        HashMap<Integer, String> coPlay = new HashMap <Integer, String> ();
        for (String x: gSet) {
            int count = 0;
            for (int i = 0 ; i < genreMap.size(); i++) {
               if (genreMap.get(i).equals(x)) {
                  count += playMap.get(i);//?
              }
            }
            coPlay.put(count, x);
        }

        //★ <플레이 횟수, 장르> hash Map 정렬  TreeMap
          TreeMap sort = new TreeMap(coPlay);
        // String 형의 배열에 넣는다
          String[] sortGenre = new String[gSet.size()];
          int index = 0;
          for (Object o : sort.keySet()) {
              sortGenre[index] = sort.get(o).toString();
              index++;
          }

          // 장르별 많이 플레이 된 노래의 <고유번호> 찾기
          ArrayList<Integer> fIndex = new ArrayList<Integer>();
          for (int i = sortGenre.length-1; i >= 0; i--){
             int count = 0;
             for (int pl: genreMap.keySet()){     // 여기서 오류 난다. int[]를 Integer[]로 변환할 수 없다며;
                  if (sortGenre[i].equals(genreMap.get(pl))){
                      count++;
                    }
               }
               int[] temp = new int[count];
               int k = 0;
               for (int p2 : genreMap.keySet()){
                 if (sortGenre[i].equals(genreMap.get(p2))){
                      temp[k] = playMap.get(p2);  //  <Integer> 고유번호
                      k++;
                 }
               }
               if (temp.length != 1) {
                  Arrays.sort(temp);
               }

               for (int j = temp.length -1; j >= temp.length -2; j--) {
                 for (int p : playMap.keySet()){
                   if (temp[j] == playMap.get(p)){
                      fIndex.add(p); //ArrayList에 key 값 순서대로 추가
                      playMap.put(p,0);
                      break;
                   }
                 }
               }
          }
           // ArrayList 를 일반 배열로 복사하여 return 한다.
           int [] answer = new int[fIndex.size()];
           for (int i = 0 ; i < fIndex.size(); i++){
              answer[i] = fIndex.get(i);
           }
           return answer;
          }

}

```
