import java.util.Scanner;

public class Virus_2602 {
	static boolean edge[][];
	static boolean visited[];
	static int n; //컴퓨터의 수
	static int m; //직접 연결되어 있는 컴퓨터의 번호 쌍
	static int result = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();
		m = scan.nextInt();
		edge = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++){
			int u = scan.nextInt();
			int v = scan.nextInt();
			edge[u][v] = edge[v][u] = true;
		}
		 dfs(1);
		 System.out.println(result);
	}
	public static void dfs(int cur){
		visited[cur] = true;
		for(int i = 1; i <= n; i++){
			if(visited[i] || !edge[cur][i]) 
				continue;
			dfs(i);
			result++;
		}
	}
}
