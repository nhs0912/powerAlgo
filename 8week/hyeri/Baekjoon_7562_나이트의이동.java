import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class KnightMove_7562 {
	static int length;
	static int visited[][];
	static ArrayList<Point> queue;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 테스트 케이스

		for (int test_case = 0; test_case < n; test_case++) {
			length = scan.nextInt(); // 체스판의 한 변의 길이

			int curr_x = scan.nextInt(); //시작 x 좌표
			int curr_y = scan.nextInt(); //시작 y 좌표

			int end_x = scan.nextInt(); //목적지 x 좌표
			int end_y = scan.nextInt(); //목적지 y 좌표

			visited = new int[length][length];
			queue = new ArrayList<Point>();

			BFS(curr_x, curr_y, end_x, end_y);
		}
	}

	static void BFS(int curr_x, int curr_y, int end_x, int end_y) {
		int[] move_x = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] move_y = { -1, -2, -2, -1, 1, 2, 2, 1 };

		int level = 0;
		visited[curr_x][curr_y] = 1;
		queue.add(new Point(curr_x, curr_y));

		while (!(queue.isEmpty())) {
			int queue_size = queue.size();

			for (int i = 0; i < queue_size; i++) {
				curr_x = queue.get(0).x;
				curr_y = queue.get(0).y;
				queue.remove(0);

				if (curr_x == end_x && curr_y == end_y) {
					System.out.println(level);
					break;
				}

				for (int j = 0; j < 8; j++) {
					int next_x = move_x[j] + curr_x;
					int next_y = move_y[j] + curr_y;

					if (next_x < length && next_y < length && next_x >= 0 && next_y >= 0) {
						if (visited[next_x][next_y] == 0) {
							visited[next_x][next_y] = 1;
							queue.add(new Point(next_x, next_y));
						}
					}
				}
			}
			level++;
		}
	}
}
