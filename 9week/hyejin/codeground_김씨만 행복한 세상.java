import java.util.*;

class Solution {
	public static int N, M, a, b;
	public static boolean[][] vertex;
	public static boolean[] visited;
	public static char[] manager;
	
	public static int bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		manager[v] = 'A';
			
		while(!queue.isEmpty()) {
			int vRemove = queue.remove();
			
			for(int i=1; i<=N; i++) {
				if(vertex[vRemove][i] && !visited[i]) {
					if(manager[vRemove] != 'A')
						manager[i] = 'A';
					else
						manager[i] = 'B';
					
					queue.add(i);
					visited[i] = true;
					
				} else if(vertex[vRemove][i] && visited[i]) {
					if(manager[vRemove] == manager[i])
						return 0;
				}
			}
		}
		return 1;
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int test_case = 0; test_case < TC; test_case++) {
			N = sc.nextInt();	//지역의 갯수
			M = sc.nextInt();	//인접한 지역의 수
			
			vertex = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			manager = new char[N+1];
			
			for(int i=0; i<M; i++) {
				a = sc.nextInt();	//인접한 두개의 지역번호
				b = sc.nextInt();
				vertex[a][b] = vertex[b][a] = true;
			}
      
			System.out.println("Case #"+(test_case+1));
			System.out.println(bfs(1));
		}
	}
}
