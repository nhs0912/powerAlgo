import java.util.Scanner;
import java.util.Queue; 
import java.util.LinkedList; 

public class Main {
	private class Point {
		public int x, y; 
		public boolean breakWall; 

		public Point(int x, int y, boolean breakWall) {
			this.x = x; 
			this.y = y; 
			this.breakWall = breakWall; 
		}
	}

	private static final Scanner scanner = new Scanner(System.in); 
	private int width, height, wallMap[][]; 

	public Main() {
		width = scanner.nextInt(); 
		height = scanner.nextInt(); 

		wallMap = new int[width][height];

		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				wallMap[i][j] = scanner.nextInt(); 
			}
		}
	}

	public void solve() { 
		int visited[][] = new int[width][height]; 
		int minDistMap[][] = new int[width][height]; 

		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				visited[i][j] = false; 
				minDistMap[i][j] = Integer.MAX_VALUE; 
			}
		}

		Queue<Integer> q = new LinkedList<>();		

	}

	public static void main(String[] args) {
		Main main = new main(); 
		main.solve(); 
	}
}