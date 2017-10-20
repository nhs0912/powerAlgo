package samsung;

import java.util.Scanner;

public class 텀프로젝트2 {
	static int n;
	static int[][] mat;
	static boolean[] isVisit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			n = sc.nextInt(); // 학생수
			mat = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				int j = sc.nextInt();
				mat[i][j] = 1;
			}

			for (int i = 1; i <= n; i++) {
				isVisit = new boolean[n + 1];
				if (!isVisit[i]) {
					dfs(i);
				}
			}
		}
	}

	public static void dfs(int v) {
		isVisit[v] = true;
		for (int i = 1; i <= n; i++) {
			if (mat[v][i] == 1 && !isVisit[i]) {
				dfs(i);
			}
		}
	}

}
