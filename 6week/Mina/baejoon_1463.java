package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 일로만들기bfs {
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		bfs(N);
		System.out.println(count - 1);
	}

	public static void bfs(int N) {
		if (N == 1) {
			count = 1;
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				int x = queue.poll();
				if (x == 1) {
					return;
				}
				if (x % 3 == 0) {
					queue.add(x / 3);
				}
				if (x % 2 == 0) {
					queue.add(x / 2);
				}
				queue.add(x - 1);
			}

		}
	}
}
