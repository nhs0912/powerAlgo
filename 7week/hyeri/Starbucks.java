
import java.util.Scanner;

class Starbucks {
	static String Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			int N = sc.nextInt(); //사원 수
			int M = sc.nextInt(); //커피 종류
			int K = sc.nextInt(); //지출 한계치
			
			int favorite[] = new int[N]; //선호하는 커피 저장
			int price[] = new int[M]; //가격 저장
			
			for(int i=0; i<N; i++){
				favorite[i] = sc.nextInt();
			}
			
			for(int i=0; i<M; i++){
				price[i] = sc.nextInt();
			}
			
			int price_sum = 0;
			for(int i=0; i<N; i++){
				price_sum += price[favorite[i]-1];
			}
			
			if(price_sum<=K){
				Answer = "Y";
			}else
				Answer = "N";
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}