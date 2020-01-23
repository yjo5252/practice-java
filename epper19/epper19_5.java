//epper19_5.java

/*
** ���� (2020.01.23)**
 'a'���� 'z'���� "�켱����ť""�� ����� �ش� ���ڷ� �����ϴ� �ܾ���� ť�� ���� ��,
 �ܾ� ������ ���۵Ǿ� ù ���ڰ� �־����� �� ���ڿ� �����Ǵ� �켱���� ť����
 �ܾ poll() �Ͽ� ����Ѵ�.
 �� �������� �켱����ť�� ����ϱ� ���� Comparable�� implements �� word Ŭ������ ����������,
 �������� �־��� ���Ǵ�� �ܾ �����ϵ��� compareto()�� �������̵� �ߴ�.
*/
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

Class Word implements Comparable<Word>{
  String word;
  int count;//���� Ƚ��

  public Word(String word){
    this.word = word;
    this.count = 0;
  }

  @Override
  public int compareTo(Word o){//** ��ü **
    //���� Ƚ���� ���� ������ ����.
    //���� Ƚ���� ���ٸ� ���ĺ� ������ ����
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

    // 'a'���� 'z'���� �� ���ڷ� �����ϴ� �ܾ ���� priorityQueue�� ���� ����
    List<PriorityQueue<Word>> pgs = new LinkedList<>();
    for (int i=0; i<('z'-'a'+1);i++)
      pqs.add(new PriorityQueu<>());

    // k,n �Է� �ޱ�
    k = sc.nextInt();
    n = sc.nextInt();
    sc.nextLine();

    //�� �� �־����� �ܾ� �Է� �ޱ�
    for (int i=0; i<k; i++){
      // �Է¹��� ���ڷ� Word �ν��Ͻ� ���� ��, �´� PriorityQueue�� ���
      word = sc.nextLine();
      pqs.get(word.charAt(0)-'a').add(new Word(word));
    }

    // �ܾ� ���� ����
    for (int i=0; i<n; i++) {
      user_input = sc.nextLine();

      // �ش� ���ڷ� �����ϴ� �ܾ� �� ���� �켱�� �� ������ ����ϱ� .
      temp_word = pgs.get(word_input.charAt(0)-'a').poll();
      System.out.println(temp_word.word);

      // �ѹ� ���������Ƿ� count ���� ��Ű�� �ٽ� queue�� �ֱ�
      temp_word.count++;
      pqs.get(user_input.charAt(0)-'a').add(temp_word);
    }

    if (n > m) System.out.println(2*(m-1));
    else System.out.pritln(2 * (n-1));
}
