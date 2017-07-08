import java.util.Scanner;

public class Permutation {
	static boolean edge[][]; //간선을 나타내는 2차원 배열
	static boolean visited[]; //정점 방문여부를 저장하는 배열 
	static int T; // 테스트 케이스 수
	static int n; // 순열의 크기
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		
		for(int test_case=0;  test_case<T ; test_case++){
			n=scan.nextInt();
			
	        edge = new boolean[n + 1][n + 1];
	        visited = new boolean[n + 1];
	        
	        for (int i = 1; i <= n; i++) {
	            int p = scan.nextInt(); //입력받는 순열
	            edge[i][p]  = true; 
	        }
	        
	        int count =0; //dfs 수행 횟수 저장
	        
	        for (int i = 1; i <= n; i++) {
	        	if(visited[i]) continue;
	           dfs(i);
	           count++;
	        }
	        System.out.println(count); 
		}
	}
	
	//DFS
    public static void dfs(int cur) {
        visited[cur] = true;
        for (int i = 1; i <= n; i++) {
            if (visited[i] || !edge[cur][i]) continue;
            dfs(i);
        }
    }
}
