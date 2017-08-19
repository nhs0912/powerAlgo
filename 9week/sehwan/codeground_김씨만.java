import java.util.Scanner; 

public class Solution {
	private static final Scanner scanner = new Scanner(System.in); 
	private int numVertices, numEdges; 
	private boolean graph[][]; 
	private char marks[];

	public Solution() { 
		numVertices = scanner.nextInt(); 
		numEdges = scanner.nextInt(); 
		graph = new boolean[numVertices][numVertices]; 
		marks = new char[numVertices]; 

		for(int i = 0; i < numVertices; i++) {
			marks[i] = 0; 
		}

		int v1, v2; 
		for(int i = 0; i < numEdges; i++) {
			v1 = scanner.nextInt() - 1; 
			v2 = scanner.nextInt() - 1; 

			graph[v1][v2] = true; 
			graph[v2][v1] = true;
		}
	}

	private boolean dfs(int vertex, char mark) { 
		if(marks[vertex] > 0) {
			if(marks[vertex] != mark)
				return false; 
			else 
				return true; 
		} 
			
		marks[vertex] = mark; 

		char nextMark; 
		if (mark == 1) {
			nextMark = 2; 
		} else {
			nextMark = 1; 
		}

		for(int i = 0; i < numVertices; i++) { 
			if(graph[vertex][i]) {
				if(!dfs(i, nextMark)) 
					return false;  
			}
		}
		return true; 
	}

	public void solve() { 
		for(int i = 0; i < numVertices; i++) {
			if(marks[i] == 0) {
				if(!dfs(i, (char) 1)) {
					System.out.println("0");
					return; 
				}
				else { 
					System.out.println("1"); 
					return; 
				}
			}
		}
	}

	public static void main(String[] args) { 
		int numTestCases = scanner.nextInt(); 

		for(int i = 0; i < numTestCases; i++) {
			Solution sol = new Solution(); 
			System.out.println("Case #" + (i + 1)); 
			sol.solve();
		}
	}
}