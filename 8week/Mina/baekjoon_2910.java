package datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 빈도정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 주어진 배열의 크기
		int c = sc.nextInt(); // c보다 작은 수들

		int[][] index = new int[n][2];
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();

			for (int j = 0; j < n; j++) {
				if (index[j][0] == tmp) {
					++index[j][1];
					break;
				} else if (index[j][0] == 0) {
					index[j][0] = tmp;
					++index[j][1];
					break;
				}
			}
		}

		Arrays.sort(index, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}

		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < index[i][1]; j++) {
				System.out.print((i == 0 && j == 0 ? "" : " ") + index[i][0]);
			}
		}
	}
}
