import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean edge[][]; //간선을 나타내는 2차원 배열
	static boolean visited[]; //정점 방문여부를 저장하는 배열
	static int n; //정점의 개수
	static int m; // 간선의 개수
	static int v; //탐색을 시작하는 정점의 번호
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
        edge = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            edge[u][v] = edge[v][u] = true; // 입력으로 주어지는 간선이 양방향이므로
        }
        
        dfs(v);
       
        for (int i = 0; i <= n; i++) {
           visited[i] = false;
        }
        
        System.out.println(); 
        bfs(v);
	}
	
	//DFS
    public static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(String.valueOf(cur) + ' ');
  
        for (int i = 1; i <= n; i++) {
            if (visited[i] || !edge[cur][i]) continue;
            dfs(i);
        }
    }
	
	//BFS
    public static void bfs(int cur) {
        Queue<Integer> q = new LinkedList<>();
        visited[cur] = true;
        q.add(cur);
        while (!q.isEmpty()) {
            int here = q.remove();
            System.out.print(String.valueOf(here) + ' ');
            for (int there = 1; there <= n; there++) {
                if (visited[there] || (!edge[here][there])) continue;
                visited[there] = true;
                q.add(there);
            }
        }
    }
}
