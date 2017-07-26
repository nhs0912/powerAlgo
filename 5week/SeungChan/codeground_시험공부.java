import java.util.*;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // T <= 20
		
		for(int test_case = 0; test_case < T; test_case++) { // O(NlogN*T)
		    
		    int N = sc.nextInt(); // 전체 수 N <= 200,000
		    int[] points = new int[N];
		    int K = sc.nextInt(); // 선택 K <= N
		    
		    for(int i=0; i<N; i++){ // O(N)
		        points[i] = sc.nextInt();
		    }
		    Arrays.sort(points); // O(NlogN)
		    
		    for(int i=0; i<K; i++){ // O(K)
		        Answer += points[points.length-1-i];
		    }
		    
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
}
