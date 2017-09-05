package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀 {
	static int N;
	static int[][] mat;
	static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int time = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		mat = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			mat[x][y] = 2; // 사과위치
		}

		int dirNum = sc.nextInt(); // 방향변환 개수
		int[] dirTime = new int[dirNum];
		char[] dirName = new char[dirNum];
		for (int i = 0; i < dirNum; i++) {
			dirTime[i] = sc.nextInt();
			dirName[i] = sc.next().charAt(0);
		}

		// 0 동, 1 남, 2 서, 3 북 시계 반대 방향
		int dir = 0;
		int k = 0;
		Queue<Index> queue = new LinkedList<>();
		int curX = 1, curY = 1;
		queue.add(new Index(curX, curY));

		while (!queue.isEmpty()) {
			Index i = new Index(curX, curY);
			int mx = i.x + direction[dir][0];
			int my = i.y + direction[dir][1];

			// 벽
			if (mx <= 0 || mx > N || my <= 0 || my > N) {
				time++;
				break;
			}

			// 사과X, 꼬리 없애기
			if (mat[mx][my] == 0) {
				Index tail = queue.poll();
				mat[tail.x][tail.y] = 0;
			}

			// 자기 몸을 만났을 때
			if (mat[mx][my] == 1) {
				time++;
				break;
			}

			// 머리 나아가기
			queue.add(new Index(mx, my));
			mat[mx][my] = 1;
			curX = mx;
			curY = my;
			time++;

			if (dirTime[k] == time) {
				if (dirName[k] == 'L') { // 왼쪽
					dir = (dir + 3) % 4;
				} else if (dirName[k] == 'D') { // 오른쪽
					dir = (dir + 1) % 4;
				}
				k++;
			}
		}

		System.out.println(time);
	}

}

class Index {
	int x, y;

	public Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
