package bfsdfs;

import java.util.Scanner;

public class dfs11403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력 끝

		// 결과배열
		int[][] result = new int[N + 1][N + 1];
		// map의 한 행 만큼씩 진행
		for (int i = 1; i < N + 1; i++) {
			int[] isVisit = new int[N + 1];
			dfs(map, isVisit, i, true);
			result[i] = isVisit;
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(int[][] map, int[] isVisit, int v, boolean isFirst) {
		// 시작정점인지 확인
		if (!isFirst) {
			isVisit[v] = 1;
		}
		for (int i = 1; i < map.length; i++) {
			if (map[v][i] == 1 && isVisit[i] == 0) {
				dfs(map, isVisit, i, false);
			}
		}
	}
}
