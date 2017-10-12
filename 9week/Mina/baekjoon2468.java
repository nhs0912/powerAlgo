import java.util.Arrays;
import java.util.Scanner;

// 안전영역
public class Main {
	private static int[][] area;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		area = new int[N][N]; // 높이정보
		boolean[][] visit = new boolean[N][N];
		int maxHeight = 0;
		int max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				area[i][j] = sc.nextInt();
				if (maxHeight < area[i][j]) {
					maxHeight = area[i][j];
				}
			}
		}

		for (int h = 1; h <= maxHeight; h++) {
			// h가 달라질때마다 visit 초기화 작업
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(visit[i], false);
				}
			}
			// 잠긴 지역 true로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (area[i][j] <= h) {
						visit[i][j] = true;
					}
				}
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(i, j, visit);
						count++;
					}
				}
			}
			max = Math.max(count, max);
		}
		System.out.println(max);
	}

	public static void bfs(int x, int y, boolean[][] visit) {
		if (x < 0 || y < 0 || x >= area.length || y >= area.length)
			return;

		if (visit[x][y])
			return;

		visit[x][y] = true;
		bfs(x - 1, y, visit);
		bfs(x + 1, y, visit);
		bfs(x, y - 1, visit);
		bfs(x, y + 1, visit);
	}
}
