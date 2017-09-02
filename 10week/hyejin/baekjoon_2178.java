import java.util.*;

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static Queue<Point> qu = new LinkedList<>();
	
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		qu.add(new Point(x, y));
		
		while(!qu.isEmpty()) {
			Point p = qu.remove();
			
			for(int i=0; i<4; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				
				if(1 <= cx && cx <= n && 1 <= cy && cy <= m){
					if (map[cx][cy] == 1 && !visited[cx][cy]) {
						visited[cx][cy] = true;
						map[cx][cy] = map[p.x][p.y] + 1;
						qu.add(new Point(cx, cy));
					}
				}
			}
		}
		
		System.out.println(map[n][m]);
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			String s = sc.next();
			
			for(int j=1; j<=m; j++)
				map[i][j] = s.charAt(j-1) - '0';
		}
		
		bfs(1, 1);
	}
}
