package samsung;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/9466
 * https://www.acmicpc.net/source/4279855
 * 
 */
public class 텀프로젝트 {
	static int n;
	static int[] mat;
	static boolean[] isVisit;
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

			int numOfTeam = 0;
			for (int i = 1; i <= n; i++) {
				isVisit = new boolean[n + 1];
				if (!isVisit[i]) {
					isVisit[i] = true;
					dfs(i, i, true);
				}
			}
		}

	}

	public static void dfs(int first, int v, boolean isFirst) {
		if (!isFirst) { // 처음이 아닌 경우
			if (!isVisit[v]) {
				isVisit[v] = true;
			} else {
				// 이미 방문...
				return;
			}
		}

		// 돌다가.. 처음시작한 정점으로 왔을 때
		if (first == mat[v]) {
			isVisit[mat[v]] = true;
			
			return;
		}

		dfs(first, mat[v], false);
	}

}
