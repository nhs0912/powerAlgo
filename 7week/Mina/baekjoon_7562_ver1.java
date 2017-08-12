package bfsdfs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class bfs7562 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt(); // 체스판 크기
			int[][] mat = new int[N][N];
			int startX = sc.nextInt();
			int startY = sc.nextInt();

			int distX = sc.nextInt();
			int distY = sc.nextInt();

			int answer = 0;

			Queue<CPoint> queue = new LinkedList<>();
			queue.add(new CPoint(startX, startY));
			int[][] direction = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 },
					{ 2, 1 } };
			while (!queue.isEmpty()) {
				CPoint p = queue.poll();
				if (p.x == distX && p.y == distY) {
					answer = mat[p.x][p.y];
					break;
				}
				for (int i = 0; i < 8; i++) {
					int mx = p.x + direction[i][0];
					int my = p.y + direction[i][1];
					if (mx < 0 || my < 0 || mx >= N || my >= N || mat[mx][my] != 0) {
						continue;
					}

					mat[mx][my] = mat[p.x][p.y] + 1;

					queue.add(new CPoint(mx, my));
				}
			}
			System.out.println(answer);
		}

	}

}

class CPoint {
	int x, y;

	public CPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
