import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

	int[][] map;
	int N, M;// map[N][M]
	// 방향 : 동서남북
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };
	boolean[][] visited;
	boolean[][] changedIce;
	int[][] body;

	class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	public void BFS(int x, int y, int cnt) {
		visited[x][y] = true;
		Queue<Position> q = new LinkedList();
		Position p = new Position(x, y);
		q.add(p);

		while (!q.isEmpty()) {
			Position curP = q.remove();
			body[curP.x][curP.y] = cnt;
			for (int i = 0; i < 4; i++) {
				int moveX = curP.x + dx[i];
				int moveY = curP.y + dy[i];

				if (moveX < 0 && moveY < 0 && moveX >= map.length && moveY >= map.length) {
					continue;
				}
				if (!visited[moveX][moveY] && map[moveX][moveY] != 0) {
					Position newP = new Position(moveX, moveY);
					q.add(newP);
					visited[newP.x][newP.y] = true;
				}

			}

		}

	}

	public int getBodyCnt() {
		int bigCnt = 0;
		for (int i = 0; i < body.length; i++) {
			for (int j = 0; j < body[i].length; j++) {
				int num = body[i][j];
				if (bigCnt < num) {
					bigCnt = num;
				}
			}
		}
		// System.out.println("bigCnt = " + bigCnt);
		return bigCnt;
	}

	public int checkBody() {
		visited = new boolean[N][M];
		body = new int[N][M];
		int cnt = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					BFS(i, j, cnt++);
				}
			}
		}

		return getBodyCnt();

	}

	public void searchICE() {
		// 0이 아닌 빙산을 찾는 과정
		changedIce = new boolean[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					// 빙산을 만났다면
					int zeroCnt = 0;
					for (int k = 0; k < 4; k++) {
						// 동서남북으로 탐색해서 0의 갯수를 센다.
						int moveX = i + dx[k];
						int moveY = j + dy[k];
						if (moveX < 0 && moveY < 0 && moveX >= map.length && moveY >= map.length) {
							continue;
						}
						if (!changedIce[moveX][moveY] && map[moveX][moveY] == 0) {
							zeroCnt++;
						}
					}

					map[i][j] -= zeroCnt;
					if (map[i][j] < 0) {
						map[i][j] = 0;
					}
					changedIce[i][j] = true;
				}
			}
		}
	}

	public boolean allMeltedIce() {
		boolean allZero = true;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					allZero = false;
				}
			}
		}

		return allZero;
	}

	public void solve() throws IOException {
		inputData();
		// print(map);
		long year = 0;

		while (true) {

			if (checkBody() > 1) {
				break;
			}

			if (allMeltedIce()) {
				year = 0;
				break;
			}
			year++;
			searchICE();
		}
		// print(map);
		System.out.println(year);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
