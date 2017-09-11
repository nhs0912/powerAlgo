package study;

import java.util.Scanner;

// 14503
public class 로봇청소기 {
	// 북동남서, 시계방향
	static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] map;
	static int count = 1;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		int startX = sc.nextInt();
		int startY = sc.nextInt();
		int dir = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt(); // 1은 벽 0은 빈칸
			}
		}
		map[startX][startY] = 2;
		dfs(startX, startY, dir);
		System.out.println(count);
	}

	public static void dfs(int x, int y, int dir) {
		int curDir = dir;
		for (int i = 0; i < 4; i++) {
			curDir = (curDir + 3) % 4;
			int mx = x + direction[curDir][0];
			int my = y + direction[curDir][1];

			if (mx >= n || mx < 0 || my >= m || my < 0 || map[mx][my] == 1) {
				continue;
			}

			if (map[mx][my] == 0) {
				count++;
				map[mx][my] = 2; // 방문
				dfs(mx, my, curDir);
				return;
			}
		}

		// 후진, 원래 방향을 유지한채로 후진
		curDir = (dir + 2) % 4; // 0을 보고있을 때, 2(남쪽)으로 가야함.
		int mx = x + direction[curDir][0];
		int my = y + direction[curDir][1];

		// 후진하려는 곳도 벽인 경우
		if (map[mx][my] == 1) {
			return;
		} else {
			dfs(mx, my, dir);
		}
	}
}
