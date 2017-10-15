
import java.util.Scanner;

public class Solution {
	static int[][] direction = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	static int[][] map;
	static int N;
	static int max;
	static boolean[] number;
	static boolean[][] visited;
	static int startX, startY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			number = new boolean[101];
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startX = i;
					startY = j;

					dfs(i, j, 0, 0);

				}
			}

			if (max == -1) {
				System.out.println("#" + t + " " + -1);
			} else {
				System.out.println("#" + t + " " + max);
			}
		}
	}

	public static void dfs(int i, int j, int dir, int depth) {
		visited[i][j] = true;
		number[map[i][j]] = true;

		for (int d = dir; d < 4; d++) {
			int mx = i + direction[d][0];
			int my = j + direction[d][1];

			// 원점으로 돌아오는 조건 = 종료 조건
			if (mx == startX && my == startY && depth + 1 >= 4) {
				if (max <= depth + 1) {
					max = depth + 1;
				}
				return;
			}

			if (mx < 0 || my < 0 || mx >= N || my >= N || number[map[mx][my]] || visited[mx][my]) {
				continue;
			}

			number[map[mx][my]] = true;
			visited[mx][my] = true;

			dfs(mx, my, d, depth + 1);

			number[map[mx][my]] = false;
			visited[mx][my] = false;
		}

		visited[i][j] = false;
		number[map[i][j]] = false;
	}
}
