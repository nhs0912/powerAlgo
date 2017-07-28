import java.util.*;

public class Main {
	public static int solve(int[][] map) {
		boolean[][] visited = new boolean[map.length][map.length];
		int cnt = 0;
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j] != -1 && !visited[i][j]) {
					dfs(map, visited, i, j);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean[][] dfs(int[][] map, boolean[][] visited, int i, int j) {
		if(visited[i][j]) return visited; 
		visited[i][j] = true;
		
		if (j < map.length-1 && map[i][j+1] != -1)
			dfs(map, visited, i, j+1);
		if (i < map.length-1 && map[i+1][j] != -1)
			dfs(map, visited, i+1, j);
		if (j > 0 && map[i][j-1] != -1)
			dfs(map, visited, i, j-1);
		if (i > 0 && map[i-1][j] != -1)
			dfs(map, visited, i-1, j);
		
		return visited;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++) 
				map[i][j] = sc.nextInt();
		
		int max = 1;
		
		for(int h=1; h<=100; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) { 
					if(map[i][j] < h)
						map[i][j] = -1;
				}
			}
			int temp = solve(map);
			max = temp > max ? temp : max; 
		}
		
		System.out.println(max);
	}
}
