## 코딩테스트 연습 > 해시 
### 1.  문제: 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576 
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
### 2. 전화번호부 목록 https://programmers.co.kr/learn/courses/30/lessons/42577?language=java

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
