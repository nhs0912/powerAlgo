import java.util.Scanner;

public class FindRoute_11403 {
	static int n; // 정점의 개수
	static int edge[][]; // 인접행렬
	static int result_arr[][];
	static boolean visited[];
	static int exist = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		edge = new int[n + 1][n + 1];
		result_arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				edge[i][j] = scan.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				setVisited();
				exist = 0;
				result_arr[i][j] = dfs(i, j);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(result_arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int dfs(int start_v, int end_v) {
		visited[start_v] = true;
		visited[end_v] = false;
		for (int i = 1; i <= n; i++) {
			if (visited[i] || edge[start_v][i] == 0)
				continue; 
			if (i == start_v || i == end_v) {
				exist = 1;
			}
			dfs(i, end_v);
		}
		return exist;
	}

	public static void setVisited() {
		for (int i = 1; i <= n; i++) {
			visited[i] = false;
		}
	}
}
