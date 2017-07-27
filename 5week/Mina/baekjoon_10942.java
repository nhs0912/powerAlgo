import java.util.Arrays;
import java.util.Scanner;

// 팰린드롬?
public class Solution10942 {
	private static int N;// 수열의 크기
	private static int arr[];
	private static int dp[][];

	/*
	 * Check Point
	 * 1. start 문자와 end 문자가 같은지 확인
	 * 2. start+1 과 end-1 사이의 문자가 같은지 확인
	 * 같으면 팰린드롬 다르면 아닌 것.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		// x에서 y까지 팰린드롬인지 확인하는 배열
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], -1);
		}

		// 팰린드롬이면 1, 아니면 0
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int start, end;
		for (int i = 0; i < M; i++) {
			start = sc.nextInt() - 1;
			end = sc.nextInt() - 1;
			sb.append(isPalindrome(start, end)).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int isPalindrome(int start, int end) {
		if (start >= end) { // isPalindrome의 종료 조건
			return 1;
		}

		if (dp[start][end] != -1) {
			return dp[start][end];
		}

		if (arr[start] != arr[end]) { // 다를때
			dp[start][end] = 0;
		} else {
			dp[start][end] = isPalindrome(start + 1, end - 1);
		}
		return dp[start][end];
	}
}
