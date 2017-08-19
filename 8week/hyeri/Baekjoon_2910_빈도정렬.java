import java.util.Arrays;
import java.util.Scanner;

public class FrequencySort_2910 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 정렬하는 개수
		int c = scan.nextInt();// 최대값
		int arr[] = new int[n]; //수열
		int tmp[][] = new int[n][2]; //수, 빈도 저장
		int frequent[] = new int[n]; //나오는 빈도 저장

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int index = 0;
		int duplicate_num = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] == tmp[j][0]) {
					duplicate_num++;
					tmp[j][1]++;
					frequent[j]++;
				}
			}

			if (duplicate_num == 0) {
				tmp[index][0] = arr[i];
				tmp[index][1]++;
				frequent[index]++;
				if (index < n - 1) {
					index++;
				}
			}
			duplicate_num = 0;
		}

		Arrays.sort(frequent);

		for (int i = n - 1; i >= 0; i--) {
			if (frequent[i] == 0)
				continue;
			else {
				for (int j = 0; j < index; j++) {
					if (tmp[j][1] == frequent[i]) {
						for (int a = 0; a < frequent[i]; a++) {
							System.out.print(tmp[j][0]+" ");
						}
						tmp[j][1] = 0;
					}
				}
			}
		}
	}
}
