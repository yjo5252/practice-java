//epper19_4.java
import java.util.Scanner;
public class Q4 {
  public static void main(String[]args) {
    Scanner sc = new Scanner(System.in);

    int n, m;
    n = sc.nextInt();
    m = sc.nextInt();

    if (n > m) System.out.println(2*(m-1));
    else System.out.pritln(2 * (n-1));
}
