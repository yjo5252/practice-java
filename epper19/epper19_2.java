//epper19_2.java
// ��պ��� ū ������ ����
//�Ҽ��� 3°�ڸ����� ǥ��

import java.util.Scanner;
public class Q2 {
  public static void main(String[]args) {

    int i , N, count=0;
    int sum = 0, avg = 0;
    int [] scores;// java �迭 ����

    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();     //�л� �� �Է� -> N�� ����
    scores = new int[N];  //�迭 ����

    for (i = 0; i < N; i++){
      scores[i] = sc.nextInt();
      sum += scores[i];
    }
    avg = (double)sum / N; //��� ���ϱ�  'double'

    while (i < N){
      if(scores[i] > avg) count++;
    }
    System.out.println(String.format("%.3f", (count/N)*100));// �Ҽ��� 3°�ڸ����� 
  }
}
