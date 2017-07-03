import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private class Edge implements Comparable<Edge>{
		public int destVertex; 
		public int weight;
		
		public Edge(int destVertex, int weight) {
			this.destVertex = destVertex; 
			this.weight = weight; 
		}
		@Override
		public int compareTo(Edge o) {
			if (this.weight > o.weight) 
				return 1; 
			else if (this.weight < o.weight)
				return -1;
			return 0;
		} 
	}
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int[][] weightMatrix; 
	public boolean[] visited; 
	public int[] minDist; 
	public int numVertex; 
	public int numEdge;
	public int discountPrice; 
	public int numPlan; 
	public int[][] travelPlans;
	
	public Solution() {}
	
	// Constructor
	public Solution (int numVertex) {
		init(numVertex);
	}
	
	private void init(int numVertex) {
		this.numVertex = numVertex; 
		weightMatrix = new int[numVertex][numVertex];
		visited = new boolean[numVertex];
		minDist = new int[numVertex]; 
	
		for (int i = 0; i < numVertex; i++) {
			visited[i] = false; 
			minDist[i] = 0; 
			for (int j = 0; j < numVertex; j++) {
				weightMatrix[i][j] = 0; 
			}
		}
	}
	
	public void setWeightMatrix() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		this.numVertex = Integer.parseInt(st.nextToken());
		this.numEdge = Integer.parseInt(st.nextToken());
		this.discountPrice = Integer.parseInt(st.nextToken());
		
		init(numVertex); 
		
		int fromStation, destStation, edgeWeight; 
		
		for(int i = 0; i < numEdge; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine()); 
			fromStation = Integer.parseInt(line.nextToken())-1; 
			destStation = Integer.parseInt(line.nextToken())-1; 
			edgeWeight = Integer.parseInt(line.nextToken()); 
			weightMatrix[fromStation][destStation] = edgeWeight; 
			weightMatrix[destStation][fromStation] = edgeWeight;
		}
	}
	
	public void setTravelPlans() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		this.numPlan = Integer.parseInt(st.nextToken());
		this.travelPlans = new int[numPlan][2]; 
		
		for(int i = 0; i < numPlan; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine()); 
			this.travelPlans[i][0] = Integer.parseInt(line.nextToken())-1;
			this.travelPlans[i][1] = Integer.parseInt(line.nextToken())-1; 
		}
	}
	
	public int getShortestPath(int fromVertex, int destVertex) {
		int retVal = 0; 
		Queue<Integer> queue = new LinkedList<Integer>(); 
		queue.add(fromVertex); 
		// initialize minDist list. 
		for(int i = 0; i < this.numVertex; i++) {
			visited[i] = false;
			if (i != fromVertex) {
				minDist[i] = Integer.MAX_VALUE; 
			}else {
				minDist[i] = 0; 
			}
		}
		
		int altDist, nextVertex, thisWeight; 
		PriorityQueue<Edge> neighbors = new PriorityQueue<Edge>();
		
		while(!queue.isEmpty()) {
			int currVertex = queue.remove(); 
			for(int i = 0; i < this.numVertex; i++){
				if(weightMatrix[currVertex][i] > 0 && !visited[i]){
					neighbors.add(new Edge(i, weightMatrix[currVertex][i])); 
				}
			}
			
			if (currVertex == destVertex) {
				retVal = minDist[currVertex]; 
				break;
			}
			
			while(!neighbors.isEmpty()) {
				Edge neighbor = neighbors.remove(); 
				nextVertex = neighbor.destVertex;
				thisWeight = neighbor.weight; 
				
				// skip visited vertex.
				if (visited[nextVertex]) {
					continue; 
				}
				
				altDist = minDist[currVertex] + thisWeight; 
				
				if(minDist[nextVertex] > altDist) {
					minDist[nextVertex] = altDist; 
				}
				
				queue.add(nextVertex); 
			}
			visited[currVertex] = true;
			
		}
		
		return retVal; 
	}
	
	public int calculateNumDiscountTicket() { 
		int retVal = 0; 
		
		for(int i = 0; i < this.numPlan; i++) {
			int travelCost = getShortestPath(this.travelPlans[i][0], this.travelPlans[i][1]); 
			if (travelCost > this.discountPrice) {
				retVal++; 
			}
		}
		
		return retVal; 
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int numTestCase = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < numTestCase; i++)  {
			Solution graph = new Solution();
			graph.setWeightMatrix();
			graph.setTravelPlans();
			System.out.println("Case #" + (i+1));
			System.out.println(graph.calculateNumDiscountTicket());
		}
	}
 }
