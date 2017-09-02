import java.io.FileInputStream;
import java.util.*;

class Point {
	int x, y;
	int wall;
	
	public Point(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}

public class Main {
	private static int n, m;
	private static int[][] map;
	private static int[][][] visited;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static Queue<Point> qu = new LinkedList<>();
	
	public static void bfs(int x, int y) {
		map[x][y] = 1;
		visited[x][y][0] = 1;
		qu.add(new Point(x, y, 0));
		
		while(!qu.isEmpty()) {
			Point p = qu.remove();
			
			for(int i=0; i<4; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				
				if(0 <= cx && cx < n && 0 <= cy && cy < m){
					if (map[cx][cy] == 0 && visited[cx][cy][p.wall] == 0) {
						//이동할 수 있는 벽이고(0) 방문 안했던 곳
						//전에 벽을 부쉈거나 안부쉈거나 상관 X
						visited[cx][cy][p.wall] = 1;
						map[cx][cy] = map[p.x][p.y] + 1;
						qu.add(new Point(cx, cy, p.wall));
						
					} else if (map[cx][cy] == 1 && visited[cx][cy][p.wall] == 0) {
						//이동할 수 없는 벽이고(1) 방문 안했던 곳
						if(p.wall != 1) {
							//그전에 벽을 안부쉈을 때
							visited[cx][cy][p.wall] = 1;
							map[cx][cy] = map[p.x][p.y] + 1;
							qu.add(new Point(cx, cy, 1));
						}
					}
				}
			}
		}
		
		if (map[n-1][m-1] == 0)
			System.out.println(-1);
		else
			System.out.println(map[n-1][m-1]);
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m][2];
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			
			for(int j=0; j<m; j++)
				map[i][j] = s.charAt(j) - '0';
		}
		
		bfs(0, 0);
	}
}
