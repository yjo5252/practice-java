//epper19_5.java

/*
** 참고 (2020.01.23)**
 'a'부터 'z'까지 "우선순위큐""를 만들고 해당 글자로 시작하는 단어들을 큐에 넣은 후,
 단어 게임이 시작되어 첫 글자가 주어지면 그 글자에 대응되는 우선순위 큐에서
 단어를 poll() 하여 출력한다.
 이 과정에서 우선순위큐를 사용하기 위해 Comparable을 implements 한 word 클래스를 정의했으며,
 문제에서 주어진 조건대로 단어를 정렬하도록 compareto()를 오버라이딩 했다.
*/
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

Class Word implements Comparable<Word>{
  String word;
  int count;//말한 횟수

  public Word(String word){
    this.word = word;
    this.count = 0;
  }

  @Override
  public int compareTo(Word o){//** 객체 **
    //말한 횟수가 작은 순으로 정렬.
    //말한 횟수가 같다면 알파벳 순으로 정렬
    if (this.count == o.count)
      return this.word.compareTo(o.word);
    else return this.count - o.count;
  }
}
public class Q5 {
  public static void main(String[]args) {
    Scanner sc = new Scanner(System.in);

    int k, n;
    String word, user_input;
    Word temp_word;

    // 'a'부터 'z'까지 그 글자로 시작하는 단어를 담을 priorityQueue를 각가 생성
    List<PriorityQueue<Word>> pgs = new LinkedList<>();
    for (int i=0; i<('z'-'a'+1);i++)
      pqs.add(new PriorityQueu<>());

    // k,n 입력 받기
    k = sc.nextInt();
    n = sc.nextInt();
    sc.nextLine();

    //미 리 주어지는 단어 입력 받기
    for (int i=0; i<k; i++){
      // 입력받은 글자로 Word 인스턴스 생성 후, 맞는 PriorityQueue에 담기
      word = sc.nextLine();
      pqs.get(word.charAt(0)-'a').add(new Word(word));
    }

    // 단어 게임 시작
    for (int i=0; i<n; i++) {
      user_input = sc.nextLine();

      // 해당 글자로 시작하는 단어 중 가장 우선인 것 꺼내어 출력하기 .
      temp_word = pgs.get(word_input.charAt(0)-'a').poll();
      System.out.println(temp_word.word);

      // 한번 말해졌으므로 count 증가 시키고 다시 queue에 넣기
      temp_word.count++;
      pqs.get(user_input.charAt(0)-'a').add(temp_word);
    }

    if (n > m) System.out.println(2*(m-1));
    else System.out.pritln(2 * (n-1));
}
