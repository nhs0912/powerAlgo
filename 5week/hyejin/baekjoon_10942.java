import java.util.*;

public class Main {
	private static int[] arr;
	
	public static void palindrom(int s, int e) {
		if(s == e)
			System.out.println(1);
		
		if(arr[s] == arr[e]) {
			if((s + 1) <= (e - 1))
				palindrom(s+1, e-1);
			if((e - s) == 1)
				System.out.println(1);
		} else
			System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();	//수열의 크기
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt();	//질문의 개수
		
		for(int i=0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			
			palindrom(S, E);
		}
	}
}
