import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {	
	private class Point {
		public int x, y, breakNumLeft; 
		public Point(int x, int y, int breakNumLeft) { 
			this.x = x; 
			this.y = y; 
			this.breakNumLeft = breakNumLeft; 
		}	
	}

	private static final Scanner scanner = new Scanner(System.in); 
	private final int moves[][] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	private int width, height, maxBreak, minDistMap[][][], wallMap[][]; 
	private boolean visited[][][]; 

	public Main () {
		width = scanner.nextInt(); 
		height = scanner.nextInt(); 
		maxBreak = scanner.nextInt();

		wallMap = new int[width][height];
		minDistMap = new int[width][height][maxBreak + 1]; 
		visited = new boolean[width][height][maxBreak + 1]; 

		for(int i = 0; i < width; i++) {
			int line = scanner.nextInt(); 
			for(int j = 0; j < height; j++) {
				wallMap[i][height - 1 - j] = line % 10; 
				line /= 10; 
				for(int k = 0 ; k < maxBreak + 1; k++) {
					minDistMap[i][j][k] = Integer.MAX_VALUE; 
					visited[i][j][k] = false; 
				}
			}
		}
		minDistMap[0][0][maxBreak] = 1; 
	}

	private int getShortestPath() {
		Queue<Point> q = new LinkedList<>(); 

		q.add(new Point(0, 0, maxBreak));

		while(!q.isEmpty()) {
			Point curr = q.poll(); 
			//System.out.println("DEBUG: " + curr.x + ", " + curr.y);
			int breakNumLeft = curr.breakNumLeft; 
			int altDist = minDistMap[curr.x][curr.y][curr.breakNumLeft] + 1; 

			for(int[] move : moves) {
				int nextX = curr.x + move[0]; 
				int nextY = curr.y + move[1]; 

				if (nextX < 0 || nextX >= width)
					continue; 
				if (nextY < 0 || nextY >= height)
					continue; 

				if (wallMap[nextX][nextY] == 0) {
					if(visited[nextX][nextY][breakNumLeft])
						continue; 
					else {
						minDistMap[nextX][nextY][breakNumLeft] = Math.min(altDist, minDistMap[nextX][nextY][breakNumLeft]);
						q.add(new Point(nextX, nextY, breakNumLeft));
					}
				} else {
					if(curr.breakNumLeft == 0) 
						continue;
					else {
						minDistMap[nextX][nextY][breakNumLeft - 1] = Math.min(altDist, minDistMap[nextX][nextY][breakNumLeft - 1]);
						q.add(new Point(nextX, nextY, breakNumLeft - 1)); 
					}
				}
			}
			visited[curr.x][curr.y][breakNumLeft] = true;
		}

		int min = Integer.MAX_VALUE; 
		for(int i = 0; i < maxBreak + 1; i++) {
			min = min < minDistMap[width - 1][height - 1][i] ? min : minDistMap[width - 1][height - 1][i];
		}
		if(min == Integer.MAX_VALUE) 
			return -1; 
		return min; 
	}

	private void solve() { 
		System.out.println(getShortestPath());
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve(); 
	}
}
