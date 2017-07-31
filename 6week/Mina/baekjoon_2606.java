package baekjoon;

import java.util.Scanner;

public class 바이러스 {
	static int n;
	static int[][] mat;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		mat = new int[n + 1][n + 1];
		boolean[] visit = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			mat[x][y] = mat[y][x] = 1;
		}
		// 1 감염시작
		visit[1] = true;
		find(1, visit);
		System.out.println(count);
	}

	public static void find(int x, boolean[] visit) {
		visit[x] = true;
		for (int i = 1; i < n + 1; i++) {
			if (mat[x][i] == 1 && !visit[i]) {
				visit[i] = true;
				find(i, visit);
				count++;
			}
		}
	}
}
