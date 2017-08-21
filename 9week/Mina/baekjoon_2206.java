package es02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2206
 */
public class 벽부수고이동하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		int[][][] visited = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j][0] = -1;
				visited[i][j][1] = -1;
			}
		}
		Queue<Custom> queue = new LinkedList<>();
		queue.add(new Custom(0, 0, 0));
		visited[0][0][0] = 1; // 시작점

		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!queue.isEmpty()) {
			Custom c = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = c.x + direction[i][0];
				int my = c.y + direction[i][1];
				if (mx >= 0 && mx < n && my >= 0 && my < m) {
					if (visited[mx][my][c.wall] == -1 && map[mx][my] == 0) {
						visited[mx][my][c.wall] = visited[c.x][c.y][c.wall] + 1;
						queue.add(new Custom(mx, my, c.wall));
					} else if (c.wall == 0 && visited[mx][my][c.wall] == -1 && map[mx][my] == 1) {
						visited[mx][my][1] = visited[c.x][c.y][c.wall] + 1;
						queue.add(new Custom(mx, my, 1));
					}
				}
			}
		} // end of while

		if (visited[n - 1][m - 1][0] == -1) {
			System.out.println(visited[n - 1][m - 1][1]);
		} else if (visited[n - 1][m - 1][1] == -1) {
			System.out.println(visited[n - 1][m - 1][0]);
		} else {
			System.out.println(Math.min(visited[n - 1][m - 1][0], visited[n - 1][m - 1][1]));
		}
	}

}

class Custom {
	int x, y, wall;

	public Custom(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}
