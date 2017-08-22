import java.util.*;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	private static int n, l;
	private static int[][] map;
	private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static int bfs(int startX, int startY, int endX, int endY) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(startX, startY));
		int depth = 0;
		
		while(!qu.isEmpty()) {
			Point po = qu.remove();
			
			for(int i=0; i<8; i++) {
				int cx = po.x + dx[i];
				int cy = po.y + dy[i];
				
				if(0 <= cx && cx < l && 0 <= cy && cy < l) {
					if(map[cx][cy] == 0) {
						map[cx][cy] = map[po.x][po.y] + 1;
						depth = map[cx][cy]; 
						qu.add(new Point(cx, cy));
					}
				}
				
				if(cx == endX && cy == endY) return depth;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//테스트 케이스 수
		
		for(int i=0; i<n; i++) {
			l = sc.nextInt();		//체스판 한변의 길이
			map = new int[l][l];
			
			int startX = sc.nextInt();	//시작 정점
			int startY = sc.nextInt();
			int endX = sc.nextInt();	//도착 정점
			int endY = sc.nextInt();
			
			if(startX == endX && startY == endY)
				System.out.println(0);
			else
				System.out.println(bfs(startX, startY, endX, endY));
		}
	}
}
