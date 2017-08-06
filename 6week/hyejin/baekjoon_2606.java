import java.io.FileInputStream;
import java.util.*;

public class Main {
	private static int n, l;
	private static boolean[][] vertex;
	private static boolean[] visited;
	private static int cnt = 0;
	
	public static void dfs(int v) {
		visited[v] = true;
		
		for(int i=1; i<n+1; i++) {
			if(vertex[v][i] && !visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//컴퓨터의 수
		l = sc.nextInt();	//컴퓨터간 연결쌍의 수
		vertex = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<l; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			vertex[a][b] = vertex[b][a] = true;
		}
		
		dfs(1);
		
		System.out.println(cnt);
	}
}
