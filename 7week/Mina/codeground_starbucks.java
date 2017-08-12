import java.util.Scanner;

class Solution {
	static String Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			int N = sc.nextInt(); 
			int M = sc.nextInt(); 
			int K = sc.nextInt();
			
			int preference[] = new int[N]; //선호도
			int price[] = new int[M]; // 커피 가격
			
			for(int i=0; i<N; i++){
				preference[i] = sc.nextInt();
			}
			
			for(int i=0; i<M; i++){
				price[i] = sc.nextInt();
			}
			
			int totalPrice = 0;
			for(int i=0; i<N; i++){
				totalPrice += price[preference[i]-1];
			}
			
			if(totalPrice<=K){
				Answer = "Y";
			}else
				Answer = "N";
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
