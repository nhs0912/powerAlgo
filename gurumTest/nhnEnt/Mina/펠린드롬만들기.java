
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 3;
		boolean isPalindrome = false;
		while (count-- > 0) {
			int reverseNum = reverse(num);
			num += reverseNum;
			if (num == reverse(num)) {
				System.out.println(num);
				isPalindrome = true;
				break;
			}
		}
		if (!isPalindrome) {
			System.out.println(-1);
		}
	}

	/*
	 * 수를 뒤집는다
	 * 
	 * @param num 뒤집을 수
	 * 
	 * @return 뒤집힌 수
	 */
	public static int reverse(int num) {
		int ret = 0;
		while (num > 0) {
			ret *= 10;
			double tmp = num % 10;
			num /= 10;
			ret += tmp;
		}
		return ret;
	}
}
