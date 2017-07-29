import java.util.Scanner; 

public class Main { 
	private static final Scanner scanner = new Scanner(System.in);
	private int numVertex, numEdge; 
	private boolean graph[][], visited[]; 

	public Main() {
		readAndInit(); 
	}

	private void readAndInit() {
		numVertex = scanner.nextInt(); 
		numEdge   = scanner.nextInt(); 

		graph = new boolean[numVertex][numVertex]; 
		visited = new boolean[numVertex]; 

		int from, to; 
		for(int i = 0; i < numEdge; i++) {
			from = scanner.nextInt()-1; 
			to   = scanner.nextInt()-1; 

			graph[from][to] = true; 
			graph[to][from] = true; 
		}
	}

	private void visit(int start) { 
		visited[start] = true; 
		for(int i = 0; i < numVertex; i++) {
			if(graph[start][i] && !visited[i]) {
				visit(i); 
			}
		}
	}

	private int getNumInfectedComputers(int start) { 
		for(int i = 0; i < numVertex; i++) { 
			visited[i] = false; 
		}

		visit(start);

		int count = 0;  
		for(int i = 0; i < numVertex; i++) { 
			if(visited[i]) count++; 
		}

		return count-1; 
	}

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.getNumInfectedComputers(0));
	}
}