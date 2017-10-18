import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	int[][] map;
	int[][] island;
	boolean[][] visited;
	int[] dx = { 0, 0, -1, 1 };
	int[] dy = { -1, 1, 0, 0 };

	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void inputData() throws IOException {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("test.txt"));
		int N = sc.nextInt();
		// System.out.println(N);
		map = new int[N][N];
		visited = new boolean[N][N];
		island = new int[N][N];
		sc.nextLine();
		for (int i = 0; i < map.length; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
				// System.out.print(map[i][j]);
			}
			// System.out.println();
		}

	}

	public void DFS(int x, int y, int cnt) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int moveX = x + dx[i];
			int moveY = y + dy[i];

			if (moveX < 0 || moveY < 0 || moveX >= map.length || moveY >= map[0].length) {
				continue;
			}

			if (map[moveX][moveY] == 1 && !visited[moveX][moveY]) {
				island[moveX][moveY] = cnt;
				DFS(moveX, moveY, cnt);
			}
		}

	}

	public void markNumbering() {
		int cnt = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					island[i][j] = ++cnt;
					DFS(i, j, cnt);
				}
			}
		}
		getCnt(cnt);

	}

	public void getCnt(int cnt) {

		int[] result = new int[cnt + 1];
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[i].length; j++) {
				if (island[i][j] != 0) {
					int index = island[i][j];
					result[index]++;
				}
			}
		}

		System.out.println(cnt);
		Arrays.sort(result);
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public void Solve() throws IOException {
		inputData();
		markNumbering();

		// print(island);
	}

	public static void main(String[] args) throws IOException {
		new Main().Solve();
	}
}
