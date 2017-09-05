package study;

import java.util.Scanner;

// 1916
public class 최소비용구하기 {
	static int inf = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 도시

		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = inf;
			}
		}

		int m = sc.nextInt();// 버스
		for (int i = 1; i < m + 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (map[x][y] > z) {
				map[x][y] = z;
			}
		}

		int startX = sc.nextInt();
		int endY = sc.nextInt();

		int[] dist = new int[n + 1];
		boolean[] visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			dist[i] = inf;
			visit[i] = false;
		}

		dist[startX] = 0;

		for (int i = 1; i <= n; i++) {
			int min = inf + 1;
			int v = 0;
			for (int j = 1; j <= n; j++) {
				if (visit[j] == false && min > dist[j]) {
					min = dist[j];
					v = j;
				}
			}

			visit[v] = true;

			for (int j = 1; j <= n; j++) {
				if (dist[j] > dist[v] + map[v][j]) {
					dist[j] = dist[v] + map[v][j];
				}
			}
		}
		System.out.println(dist[endY]);
	}
}
