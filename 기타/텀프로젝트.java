package samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/9466
 * https://www.acmicpc.net/source/4279855
 * 
 */
public class 텀프로젝트 {
	static int n;
	static int[] mat;
	static boolean[] visited;
	static boolean[] isTeam;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			n = sc.nextInt(); // 학생수
			mat = new int[n + 1];
			isTeam = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				mat[i] = sc.nextInt();
			}

			for (int i = 1; i <= n; i++) {
				visited = new boolean[n + 1];
				if (!visited[i]) {
					dfs(i, new ArrayList<>());
				}
			}

			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (isTeam[i]) {
					ans++;
				}
			}
			System.out.println(n - ans);
		}

	}

	public static void dfs(int v, List<Integer> prev) {
		if (visited[v]) {
			boolean flag = false;
			for (int vertex : prev) {
				if (vertex == v) {
					flag = true;
				}

				if (flag) {
					isTeam[vertex] = true;
				}
			}
			return;
		}

		// 방문하지 않은 정점을 만났을 때 순회를 계속 해줘야 한다.
		visited[v] = true;
		prev.add(v);
		dfs(mat[v], prev);
	}

}
