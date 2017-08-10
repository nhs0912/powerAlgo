import java.util.Scanner; 

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private int n, graph[][], answer[][];
	private boolean visited[]; 

	public Main() {
		n = scanner.nextInt(); 
		graph = new int[n][n];
		visited = new boolean[n]; 
		answer = new int[n][n]; 

		for(int i = 0; i < n; i++) {
			visited[i] = false;
			for(int j = 0; j < n; j++) {
				graph[i][j] = scanner.nextInt(); 
				answer[i][j] = 0; 
			}
		}
	}	

	private void dfsTouch(int curr, boolean isStart) {
		if(!isStart)
			visited[curr] = true; 

		for(int i = 0; i < n; i++) {
			if(graph[curr][i] > 0 && !visited[i]) {
				dfsTouch(i, false);
			}
		}
	}

	private void printAnswer() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println(); 
		}
	}

	public void solve() { 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				visited[j] = false; 
			}	
			dfsTouch(i, true);			
			for(int j = 0; j < n; j++) {
				if(visited[j]){
					answer[i][j] = 1; 
				}
			}
		}
		printAnswer(); 
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.solve(); 
	}	
}