package samsung;

import java.util.Scanner;

public class 알파벳 {
	static int R, C;
	static char[][] mat;
	static boolean[][] visited;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static String s = new String();
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		mat = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				mat[i][j] = str.charAt(j);
			}
		} // end of input

		dfs(0, 0, s);
		System.out.println(ans);

	}

	public static void dfs(int x, int y, String s) {
		if (ans < s.length()) {
			ans = s.length();
		}
		if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y] || s.indexOf(mat[x][y]) != -1) {
			return;
		}

		visited[x][y] = true;

		dfs(x - 1, y, s + mat[x][y]);
		dfs(x + 1, y, s + mat[x][y]);
		dfs(x, y - 1, s + mat[x][y]);
		dfs(x, y + 1, s + mat[x][y]);

		visited[x][y] = false;
	}
}
