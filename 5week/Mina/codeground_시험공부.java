package samsung;

import java.util.Arrays;
// 시험 공부 (연습문제 번호 3)
import java.util.Scanner;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			int N = sc.nextInt(); // 총 과목의 수
			int K = sc.nextInt(); // 선택할 과목의 수

			// 해당 과목을 공부했을 때 받을 수 있는 점수 나열
			int[] point = new int[N];
			for (int i = 0; i < N; i++) {
				point[i] = sc.nextInt();
			}
      
			Arrays.sort(point);
			
      for (int i = 0; i < K; i++) {
				Answer += point[N - 1 - i];
			} // K 과목의 개수 높은 점수 합계

			// Print the answer to standard output(screen).
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
	}
}
