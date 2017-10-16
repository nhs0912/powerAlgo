import java.util.Scanner;

public class Solution {
	// N의 최댓값
	static int MAXN = 10;
	// M의 최댓값
	static int MAXM = 7;
	// 용기의 꿀 정보
	static int h[][] = new int[MAXN][MAXN];
	// 벌통의 최대 수익 정보
	static int r[][] = new int[MAXN][MAXN];
	// 테스트케이스 변수
	static int tc, T;
	// 현재 테스트 케이스의 N,M,C 값
	static int N, M, C;

	// (y,x)를 가장 왼쪽 좌표로 두는 벌통에서의 최대수익을 계산하는 재귀함수
	static int getPSum(int m, int y, int x, int sum, int psum) {
		if (m >= M) {
			return psum;
		}
		// 탐색한 경우의 수익을 저장하는 변수
		int nextSum;
		// 최대 수익을 저장하는 변수
		int max = 0;
		for (int i = m; i < M; ++i) {
			// C값을 넘지 않는 범위라면 (y,x+i) 위치의 용기를 채취해볼 수 있다.
			if (sum + h[y][x + i] <= C) {
				// (y,x+i)위치의 용기를 채취할 떄 수익을 탐색해본다.
				nextSum = getPSum(i + 1, y, x, sum + h[y][x + i], psum + h[y][x + i]*h[y][x + i]);
				// 최대수익갱신 가능한 경우갱신
				if (max < nextSum) {
					max = nextSum;
				}

			}
			// (y,x+i)위치의 용기를 채취하지 않는 겨어우도 탐색해본다.
			nextSum = getPSum(i + 1, y, x, sum, psum);
			// 최대수익 갱신 가능한 경우 갱신
			if (max < nextSum) {
				max = nextSum;
			}
		}

		// 최대 수익 반환

		return max;
	}

	// (y,x)를 가장 왼쪽 좌표로 두는 벌통과 동시에 선택가능한 벌통 중 최대 수익을 내는 벌통의 수익을 찾는 함수
	static int getMaxPair(int y, int x) {
		int maxR = 0;
		// 일단 같은 행에서 가로로 동시에 선택가능한 벌통 중 최대 수익을 찾는다.
		for (int j = x + M; j <= N - M; ++j) {
			if (maxR < r[y][j]) {
				maxR = r[y][j];
			}
		}
		// 다른 행에 있는 벌통은 무조건 동시에 선택가능하므로 수익값을 다 확인해본다.
		for (int i = y + 1; i < N; ++i) {
			for (int j = 0; j <= N - M; ++j) {
				if (maxR < r[i][j]) {
					maxR = r[i][j];
				}
			}
		}
		return maxR;
	}

	// 테스트케이스를 푼다.
	static int solve() {
		// i: 세로 순회용 변수, j : 가로 순회용 변수
		int i, j;
		// 동시에 선택가능한 두 벌통의 수익 합을 저장할 변수
		int sum;
		// 최대 수익값
		int ans = 0;

		// 모든 세로 , 가로 좌표에 대해 수행한다.
		for (i = 0; i < N; ++i) {
			// 단, (i,j)를 포함하여 가로로 M 개의 용기가 자동 선택되는 것이므로,
			// 실제 선택할 수 잇는 경우의 수는 N-M+1 가지다.(M은 반드시 N이하로만 주어진다.)
			for (j = 0; j <= N - M; ++j) {
				r[i][j] = getPSum(0, i, j, 0, 0);
			}
		}

		// 모든 세로,가로 좌표에 대해 동시에 선택가능한 두 벌토으이 수익합이 최대인경우를 찾는다.
		for (i = 0; i < N; ++i) {
			for (j = 0; j <= N - M; ++j) {
				// (i,j) 벌통과 동시에 선태각능한 벌통 중 최대 수익을 내는 벌통의 수익을 찾는다.
				sum = r[i][j] + getMaxPair(i, j);
				// 최대 수익이 갱신되는지 확인한다.
				if (ans < sum) {
					ans = sum;
				}
			}
		}
		// 최대 수익값을 반환한다.
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			// 각 (y,x)를 시작 좌표로 하는 벌통의 최대 수익 정보를 초기화한다.
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					r[i][j] = 0;
				}
			}
			// 각 용기별 꿀의 함량을 입력받는다.
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j)
					h[i][j] = sc.nextInt();
			}
			// 테스트 케이스의 답을 출력한다.
			System.out.println("#" + tc + " " + solve());
		}
	}
}
