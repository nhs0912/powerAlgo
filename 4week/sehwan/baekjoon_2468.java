import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public int size; 
	public int maxHeight; 
	public int[][] heights; 
	public boolean[][] submerged;
	public boolean[][] visited;

	public Main(int size) {
		this.size = size;
		init(size);
	}

	private void init(int size) {
		heights = new int[size][size];
		submerged = new boolean[size][size];
		visited = new boolean[size][size];
	}

	public void clearArrays() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				visited[i][j] = false; 
				submerged[i][j] = false; 
			}
		}
	}

	public void readHeights() throws IOException{
		for(int i = 0; i < size; i++) {
			int j = 0; 
 			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
 			while(tokenizer.hasMoreTokens()) {
 				heights[i][j] = Integer.parseInt(tokenizer.nextToken());
 				maxHeight = heights[i][j] > maxHeight ? heights[i][j] : maxHeight;
 				j++; 
 			}
		}
	}

	public void calculateSubmerged(int precipitation) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(heights[i][j] <= precipitation) {
					submerged[i][j] = true; 
				}
			}
		}
	}

	private void markNeighbors(int i, int j) {
		if(i < 0 || j < 0 || i >= size || j >= size) return; 
		if(visited[i][j]) return; 
		if(submerged[i][j]) return; 

		visited[i][j] = true; 
		markNeighbors(i-1, j); 
		markNeighbors(i, j-1);
		markNeighbors(i+1, j);
		markNeighbors(i, j+1);
	}

	private int calculateNumSafeArea() {
		int count = 0; 
		for(int i = 0; i < size ; i++) {
			for(int j = 0; j < size; j++) {
				if(!visited[i][j] && !submerged[i][j]){
					count++; 
					markNeighbors(i, j);
				}
			}
		}
		return count; 
	}

	public int solve() {
		int max = 1;
		int temp; 
		for(int i = 1; i < maxHeight; i++ ) {
			clearArrays(); 
			calculateSubmerged(i); 
			temp = calculateNumSafeArea(); 
			max = temp > max ? temp : max; 
		}
		return max; 
	}

	public static void main (String[] args) throws IOException {
		String line = reader.readLine(); 
		Main main = new Main(Integer.parseInt(line)); 
		main.readHeights();
		int solution = main.solve(); 
		System.out.println(solution);
	}
}