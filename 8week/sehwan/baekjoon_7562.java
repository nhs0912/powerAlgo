import java.util.Scanner; 
import java.util.Queue; 
import java.util.LinkedList; 

public class Main {
	private class Tuple {
		public int x; 
		public int y; 

		public Tuple(int x, int y) {
			this.x = x; 
			this.y = y; 
		}

		public boolean equals(Tuple o1) {
			return o1.x == this.x && o1.y == this.y; 
		}
	}

	private static final int move[][] = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
	private static final Scanner scanner = new Scanner(System.in); 
	private int boardSize; 
	private Tuple start, target; 

	public Main() {
		boardSize = scanner.nextInt(); 
		start = new Tuple(scanner.nextInt(), scanner.nextInt()); 
		target = new Tuple(scanner.nextInt(), scanner.nextInt()); 
	}

	private int getDist() {
		Queue<Tuple> q = new LinkedList<>(); 
		q.add(start); 
		int distMap[][] = new int[boardSize][boardSize];

		while(!q.isEmpty()) {
			Tuple curr = q.poll();

			if(curr.equals(target)) 
				return distMap[curr.x][curr.y];
			
			for(int[] m : move) {
				Tuple next = new Tuple(curr.x + m[0], curr.y + m[1]); 
				if(next.x < 0 || next.y < 0 || next.x >= boardSize || next.y >= boardSize) 
					continue; 
				if(distMap[next.x][next.y] > 0)
					continue; 

				distMap[next.x][next.y] = distMap[curr.x][curr.y] + 1; 
				q.add(next); 
			}
		}
		return 0;
	}

	public void solve() {
		System.out.println(getDist());
	}

	public static void main(String[] args) {
		int numTestCases = scanner.nextInt(); 

		for(int i = 0; i < numTestCases; i++) {
			Main main = new Main(); 
			main.solve();
		}	
	}
}