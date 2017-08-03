import java.util.Scanner;

public class MakeOne_1463 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 주어지는 수
		int count[] = new int[n + 1];

		count[0] = 0;
		count[1] = 0;

		for (int num = 2; num < count.length; num++) {
			if (num % 2 != 0 && num % 3 != 0) {// 2와 3의 공배수
				count[num] = count[num - 1] + 1;
			} else if (num % 2 == 0 && num % 3 == 0) { // 2,3 모두 나누어 떨어지지 않을 때

				int minusOne = count[num - 1] + 1;
				int divideByTwo = count[num / 2] + 1;
				int divideByThree = count[num / 3] + 1;

				int min = minusOne;
				if (divideByTwo < minusOne) {
					min = divideByTwo;
				}
				if (divideByThree < min)
					min = divideByThree;
				count[num] = min;
			} else if (num % 2 == 0) { // 2의 배수

				int minusOne = count[num - 1] + 1;
				int divideByTwo = count[num / 2] + 1;
				int min = minusOne;

				if (divideByTwo < minusOne) {
					min = divideByTwo;
				}
				count[num] = min;
			} else if (num % 3 == 0) { // 3의 배수

				int minusOne = count[num - 1] + 1;
				int divideByThree = count[num / 3] + 1;
				int min = minusOne;

				if (divideByThree < minusOne) {
					min = divideByThree;
				}
				count[num] = min;
			}
		}
		System.out.println(count[n]);
	}
}
