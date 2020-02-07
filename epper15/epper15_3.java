import java.util.Scanner;
public class EPPER3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			if(isPrime(i) == true) System.out.print(i + " ");
		}
	}
	static boolean isPrime(int n) {
		if(n == 1) return false;
		if(n == 2) return true;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}
