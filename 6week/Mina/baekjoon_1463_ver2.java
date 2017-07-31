package baekjoon;

import java.util.Scanner;

// 1로 만들기
public class 일로만들기dp {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];

		System.out.println(solve(N));
	}

	public static int solve(int n) {
		if (n == 1) {
			return 0;
		}

		if (dp[n] > 0) {
			return dp[n];
		}

		dp[n] = solve(n - 1) + 1;

		if (n % 2 == 0) {
			int tmp = 1 + solve(n / 2);
			if (tmp < dp[n]) {
				dp[n] = tmp;
			}
		}

		if (n % 3 == 0) {
			int tmp = 1 + solve(n / 3);
			if (tmp < dp[n]) {
				dp[n] = tmp;
			}
		}
		return dp[n];
	}
}
