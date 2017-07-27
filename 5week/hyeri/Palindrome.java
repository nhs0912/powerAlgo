import java.util.Scanner;

public class Palindrome {
	static int n; // 수열의 크기
	static int m; // 질문의 개수

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		m = scan.nextInt(); // 질문의 개수
		for (int i = 0; i < m; i++) {
			int s = scan.nextInt() - 1; // 시작 인덱스
			int e = scan.nextInt() - 1; // 끝 인덱스
			int count = 0;

			// 짝수개 비교
			if ((e - s) % 2 != 0) {
				for (int j = 0; j < (e - s + 1) / 2; j++) {
					if (arr[s + j] == arr[e - j]) {
						count++;
					} else {
						System.out.println(0);
						break;
					}
				}
				if (count == (e - s + 1) / 2)
					System.out.println(1);
			} 
			//홀수개 비교
			else {
				for (int j = 0; j < (e - s) / 2; j++) {
					if (arr[s + j] == arr[e - j]) {
						count++;
					} else {
						System.out.println(0);
						break;
					}
				}
				if (count == (e - s) / 2)
					System.out.println(1);
			}
		}
	}
}
