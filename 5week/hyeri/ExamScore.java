
import java.util.Arrays;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

class ExamScore {
	static int Answer;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			int N = sc.nextInt(); // 과목의 수
			int K = sc.nextInt(); // 정우가 공부할 수 있는 과목의 수
			int score[] = new int[N];

			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
			}
			Arrays.sort(score);

			int Answer = 0;
			for (int i = 0; i < K; i++) {
				Answer += score[N - i - 1];
			}
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}
}
