import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
      int N = sc.nextInt();	//N명의 사람
			int M = sc.nextInt();	//커피종류 개수
			int K = sc.nextInt();	//지출 한계치
			int[] arr = new int[M+1];
			int sum = 0;
			
			for(int i=0; i<N; i++)
				arr[sc.nextInt()] += 1;
			
			for(int i=1; i<=M; i++)
				sum += arr[i] * sc.nextInt();
			
			System.out.println("Case #"+(test_case+1));
			if(sum <= K)
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}
}
