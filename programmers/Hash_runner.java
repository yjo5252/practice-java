//  문제: 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576 
// 자바 Hash 사용
import java util.HashMap;

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
