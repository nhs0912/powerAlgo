package study;

import java.util.Scanner;

/*
 * 이분 그래프를 판별하는 문제
 */
class 김씨만행복한세상 {
	static int Answer;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int x[] = new int[M];
			int y[] = new int[M];

			boolean check[] = new boolean[N + 1];
			Answer = 1;
			for (int i = 0; i < M; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();

				check[y[i]] = !check[x[i]];

			} // 입력 완료

			for (int i = 0; i < M; i++) {
				if (check[x[i]] == check[y[i]]) {
					Answer = 0;
				}
			}

			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}
}
