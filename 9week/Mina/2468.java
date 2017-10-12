package samsung;

import java.util.Scanner;

public class 안전영역 {
	static int N;
	static int[][] arr;
	static int[][] diection = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (maxHeight < arr[i][j]) {
					maxHeight = arr[i][j];
				}
			}
		} // end of input

		int max = 0;
		for (int h = maxHeight; h > 0; h--) {
			int[][] visited = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] <= h) {
						visited[i][j] = 1;
					}
				}
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						dfs(i, j, visited);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}

	public static void dfs(int i, int j, int[][] visited) {
		if (i < 0 || j < 0 || i >= N || j >= N || visited[i][j] == 1) {
			return;
		}

		visited[i][j] = 1;

		dfs(i - 1, j, visited);
		dfs(i, j - 1, visited);
		dfs(i + 1, j, visited);
		dfs(i, j + 1, visited);
	}
}
