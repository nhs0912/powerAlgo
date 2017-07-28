import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int test_case;
		
		int N, K;
		int[] arr;
		int sum = 0;
        
		for(test_case = 1; test_case <= TC; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			
			for(int i=0; i<arr.length; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			for(int i=1; i<=K; i++)
				sum += arr[arr.length-i];
			
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		}
	}
}
