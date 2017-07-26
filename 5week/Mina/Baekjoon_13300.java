package baekjoon;

import java.util.Scanner;

// 방배정
public class Solution13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총인원
		int K = sc.nextInt(); // 한방 최대인원

		// 행-학년, 열-성별 배열 생성
		int[][] mat = new int[7][2];
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt(); // 학년
			int grade = sc.nextInt(); // 성별(여자-0,남자-1)
			mat[grade][gender]++;
		}

		int room = 0;
		for (int i = 1; i <= 6; i++) {
			room += mat[i][0] / K;
			if (mat[i][0] % K != 0) {
				room++;
			}
			room += mat[i][1] / K;
			if (mat[i][1] % K != 0) {
				room++;
			}
		}

		System.out.println(room);
	}
}
