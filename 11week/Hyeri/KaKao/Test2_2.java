import java.util.Arrays;

public class Test2_2 {
	//�迭 �ߺ����� �ѹ��� ����ִ��� Ȯ��
	public static void main(String[] args) {
		int arr[] = { 4, 1, 3, 2 };
		int arr2[] = { 4, 1, 3 };

		System.out.println(solution(arr));
		System.out.println(solution(arr2));

	}

	public static boolean solution(int[] arr) {
		boolean answer = true;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (i + 1);
		}

		int arr_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr.length) {
				return false;
			}
			arr_sum += arr[i];
		}

		if (sum != arr_sum) {
			return false;
		}
		
		return answer;
	}

}
