import java.util.Scanner;

public class SafetyZone {
	static int N;
	static int arr[][];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N][N];
		int tmp[][] = new int[N][N];
		int max_count = 1; // 안전한 영역의 최대 개수 초기화, 비가 안오는 경우는 1
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		int min  = arr[0][0];
		int max = arr[0][0];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[i][j];

				if (arr[i][j] < min) {
					min = arr[i][j];
				} else if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}

		for (int range = min; range <= max - 1; range++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] <= range) {
						arr[i][j] = 0;
					}
				}
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0) {
						calculateZone(j, i);
						count++;
					}
				}
			}
			if (max_count < count) 
				max_count = count;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = tmp[i][j];
				}
			}
		}
		System.out.println(max_count);
	}

	// 경로찾는 메소드
	public static void calculateZone(int x, int y) {
		if (arr[y][x] != 0) {
			arr[y][x] = 0;
			
			// 왼쪽으로 이동
			if (x > 0 && arr[y][x - 1] != 0) {
				calculateZone(x - 1, y);
			}
			// 오른쪽으로 이동
			if (x < N - 1 && arr[y][x + 1] != 0) {
				calculateZone(x + 1, y);
			}
			// 아래로 이동
			if (y < N - 1 && arr[y + 1][x] != 0) {
				calculateZone(x, y + 1);
			}
			// 위로 이동
			if (y > 0 && arr[y - 1][x] != 0) {
				calculateZone(x, y - 1);
			}
		} 
	}
}
