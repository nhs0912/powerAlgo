import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.Queue; 
import java.util.LinkedList;

class Graph {
	public int numVertex, numEdge, startVertex; 
	public BufferedReader reader; 
	public boolean[][] edges;
	public boolean[] visited;

	public Graph(int numVertex, int numEdge, int startVertex, BufferedReader reader) {
		this.numVertex = numVertex; 
		this.numEdge = numEdge; 
		this.startVertex = startVertex-1; 
		this.reader = reader;

		edges = new boolean[numVertex][numVertex];
		visited = new boolean[numVertex]; 

		for(int i = 0; i < numVertex; i++) {
			for(int j = 0; j < numVertex; j++) {
				edges[i][j] = false; 
			}
		}
	}

	public void setEdges() throws IOException {
		StringTokenizer tokenizer; 

		for(int i = 0; i < this.numEdge; i++) {
			tokenizer = new StringTokenizer(this.reader.readLine());
			int fromVertex = Integer.parseInt(tokenizer.nextToken())-1; 
			int toVertex   = Integer.parseInt(tokenizer.nextToken())-1; 

			this.edges[fromVertex][toVertex] = true; 
			this.edges[toVertex][fromVertex] = true; 
		}
	}

	public void breadthFirst() {
		for(int i = 0; i < numVertex; i++) {
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<Integer>(); 
		queue.add(startVertex); 
		visited[startVertex] = true; 

		while(!queue.isEmpty()) {
			int curr = queue.remove();
			System.out.print((curr+1) + " ");

			for(int i = 0; i < numVertex; i++) {
				if(!visited[i] && edges[curr][i]) {
					queue.add(i);
					visited[i] = true; 
				}
			}
		}
		System.out.println(); 
	}

	public void depthFirst() {
		for(int i = 0; i < numVertex; i++) {
			visited[i] = false;
		}
		depthFirst(this.startVertex);
		System.out.println();
	}

	private void depthFirst(int start) {
		visited[start] = true; 
		System.out.print((start+1) + " ");

		for(int i = 0; i < this.numVertex; i++) {
			if (!visited[i] && edges[start][i]) {
				depthFirst(i);
			}
		}
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 

		int numVertex = Integer.parseInt(tokenizer.nextToken()); 
		int numEdge = Integer.parseInt(tokenizer.nextToken());
		int startVertex = Integer.parseInt(tokenizer.nextToken()); 

		Graph graph = new Graph(numVertex, numEdge, startVertex, reader);
		graph.setEdges(); 
		graph.depthFirst();
		graph.breadthFirst();
	}
}