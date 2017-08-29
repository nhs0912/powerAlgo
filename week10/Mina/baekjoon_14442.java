import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/14442
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		int[][][] visited = new int[n][m][k + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int l = 0; l <= k; l++) {
					visited[i][j][l] = -1;
				}
			}
		}
		Queue<Wall> queue = new LinkedList<>();
		queue.add(new Wall(0, 0, 0));
		visited[0][0][0] = 1; // 시작점

		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!queue.isEmpty()) {
			Wall c = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = c.x + direction[i][0];
				int my = c.y + direction[i][1];

				if (mx >= 0 && mx < n && my >= 0 && my < m) {

					if (visited[mx][my][c.wall] == -1 && map[mx][my] == 0) {
						visited[mx][my][c.wall] = visited[c.x][c.y][c.wall] + 1;
						queue.add(new Wall(mx, my, c.wall));
					} else if (c.wall < k && map[mx][my] == 1 && visited[mx][my][c.wall + 1] == -1) {
						visited[mx][my][c.wall + 1] = visited[c.x][c.y][c.wall] + 1;
						queue.add(new Wall(mx, my, c.wall + 1));
					}
				}
			}
		} // end of while

		int ans = -1;
		for (int i = 0; i <= k; i++) {
			if (visited[n - 1][m - 1][i] == 0)
				continue;
			if (ans == -1) {
				ans = visited[n - 1][m - 1][i];
			} else if (ans > visited[n - 1][m - 1][i]) {
				ans = visited[n - 1][m - 1][i];
			}
		}
		System.out.println(ans);
	}
}

class Wall {
	int x, y, wall;

	public Wall(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}
