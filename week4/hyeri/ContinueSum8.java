import java.util.Scanner;

public class ContinueSum8 {
	static int n;  //인덱스 수
	static int arr[];  //주어진 수열 저장 
	static int sum[]; // 연속합 비교를 위해 합을 저장하는 배열

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n];
		sum = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}

		int sum_max = arr[0];
		int negative_max = arr[0];
		int negative_count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (j == i)
					sum[j] = arr[j];
				else {
					sum[j] = sum[j - 1] + arr[j];
				}
				
				if (sum[j] > sum_max)
					sum_max = sum[j];
			}
			
			if (arr[i] < 0) {
				if (arr[i] > negative_max)
					negative_max = arr[i];
				negative_count++;
			}
		}
		if (negative_count == arr.length)
			System.out.println(negative_max);
		else
			System.out.println(sum_max);
	}
}
