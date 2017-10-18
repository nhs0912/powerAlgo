import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Main {
	int[][] adjArr;
	boolean[][] visited;

	public void print(int[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void inputData() throws IOException {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("test.txt"));
		int vertexCnt = sc.nextInt();
		int edgeCnt = sc.nextInt();

		adjArr = new int[vertexCnt + 1][vertexCnt + 1];
		visited = new boolean[vertexCnt + 1][vertexCnt + 1];

		for (int i = 1; i < adjArr.length; i++) {
			adjArr[i][i] = 1;
		}
		while (edgeCnt-- > 0) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjArr[v1][v2] = 1;
			adjArr[v2][v1] = 1;
		}

	}

	public void DFS(int x, int y) {
		visited[x][y] = true;
		visited[y][x] = true;
		for (int i = 1; i < adjArr.length; i++) {
			if (!visited[y][i] && adjArr[y][i] == 1) {
				DFS(y, i);
			}
		}
	}

	public int searchConnectedComponent() {
		int connectedComponent = 0;
		for (int i = 1; i < adjArr.length; i++) {
			for (int j = 1; j < adjArr[i].length; j++) {
				if (adjArr[i][j] != 0 && !visited[i][j]) {
					//System.out.println(i + " ," + j);
					connectedComponent++;
					DFS(i, j);
				}
			}
		}
		return connectedComponent;
	}

	public void Solve() throws IOException {
		inputData();
		//print(adjArr);
		System.out.println(searchConnectedComponent());
	}

	public static void main(String[] args) throws IOException {
		new Main().Solve();
	}
}
