import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

	int[][] map;
	boolean[][] visited;
	int[][] island;
	int[] dx = { 0, 0, -1, 1 };
	int[] dy = { 1, -1, 0, 0 };
	int N;
	ArrayList<coordination> list = new ArrayList<>();

	class coordination {
		int x;
		int y;
		int islandNum;

		coordination(int x, int y) {
			this.x = x;
			this.y = y;
		}

		coordination(int x, int y, int islandNum) {
			this.x = x;
			this.y = y;
			this.islandNum = islandNum;
		}

		@Override
		public String toString() {
			return "coordination [x=" + x + ", y=" + y + ", islandNum=" + islandNum + "]";
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
		map = new int[N][N];
		visited = new boolean[N][N];
		island = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

	}

	public void DFS(int x, int y, int cnt) {
		visited[x][y] = true;
		island[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int moveX = x + dx[i];
			int moveY = y + dy[i];

			if (moveX < 0 || moveY < 0 || moveX >= map.length || moveY >= map[0].length) {
				continue;
			}

			if (!visited[moveX][moveY] && map[moveX][moveY] == 1) {
				// island[moveX][moveY] = cnt;
				DFS(moveX, moveY, cnt);
			}
		}
	}

	public void markNumber() {
		int cnt = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					DFS(i, j, cnt++);
				}
			}
		}
	}

	//int number = 1;

	public void BFS(int x, int y, int cnt) {
		Queue<coordination> q = new LinkedList<>();

		visited[x][y] = true;
		coordination c = new coordination(x, y, cnt + 1);
		q.add(c);

		while (!q.isEmpty()) {
			coordination cur = q.remove();
			for (int i = 0; i < 4; i++) {
				int moveX = cur.x + dx[i];
				int moveY = cur.y + dy[i];

				if (moveX < 0 || moveY < 0 || moveX >= map.length || moveY >= map[0].length) {
					continue;
				}

				if (island[moveX][moveY] == 0) {
					//visited[moveX][moveY] = true;
					// island[moveX][moveY] = number++;
					coordination newC = new coordination(moveX, moveY, island[x][y]);
					list.add(newC);

				}

			}

		}

	}

	public int ABS(int num) {
		return (num > 0) ? num : -num;
	}

	public void calculateDistance() {
		int minNum = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			coordination c1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				coordination c2 = list.get(j);
				if (c1.islandNum != c2.islandNum) {
					int distance = ABS(c1.x - c2.x) + ABS(c1.y - c2.y) + 1;
					if (minNum > distance) {
						// System.out.println(c1.x + "," + c1.y);
						// System.out.println(c2.x + "," + c2.y);
						minNum = distance;
					}
				}
			}
		}
		System.out.println(minNum);
	}

	public void installBridge() {
		visited = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visited[i][j] && island[i][j] != 0)
					BFS(i, j, 0);
			}
		}
	}

	public void Solve() throws IOException {
		inputData();
		markNumber();
		// print(island);
		installBridge();
		// print(island);

		 for (coordination c : list) {
		 System.out.println(c.toString());
		 }
		calculateDistance();
	}

	public static void main(String[] args) throws IOException {
		new Main().Solve();
	}

}
