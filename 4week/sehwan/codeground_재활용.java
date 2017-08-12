import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 
import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.Comparator;

public class Solution {
	private final int BIG = 2000000000;
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public int[] houseLocs;
	public int[][] partialDistSum, dp; 
	public int numHouses, numTrashCan; 

	public Solution(int numHouses, int numTrashCan) {
		this.numHouses = numHouses; 
		this.numTrashCan = numTrashCan; 
		this.houseLocs = new int[numHouses];
		this.partialDistSum = new int[numHouses][numHouses];
		this.dp = new int[numHouses][numTrashCan+1];

		for(int i = 0; i < numHouses; i++) {
			for(int j = 0; j < numTrashCan+1; j++) {
				this.dp[i][j] = Integer.MAX_VALUE; 
			}
		}
	}

	// read data 
	public void readHouseLocs() throws IOException {
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
		int i = 0; 
		while (tokenizer.hasMoreTokens()) {
			houseLocs[i++] = Integer.parseInt(tokenizer.nextToken()); 
		}	
		// Sort the array. O(n log n)
		Arrays.sort(houseLocs); 
	}
	
	// O(n) 
	// start and end are included. 
	public int getTotalDist(int start, int end) {
		int length = end - start + 1 ; 
		int sum = 0; 
		int mid = length / 2 + start ; 
		int lo, hi; 
		// even number of elements 
		if (length % 2 == 0) {
			lo = mid-1; 
			hi = mid; 
		}
		// odd number of elements  
		else {
			lo = mid-1;
			hi = mid+1; 
		}

		while( lo >= start && hi <= end ) {
			sum += houseLocs[hi++] - houseLocs[lo--]; 
		}
		return sum; 
	}

	public void getPartialDistSum() {
		for(int i = 0; i < numHouses; i++) {
			for(int j = i+1; j < numHouses; j++) {
				partialDistSum[i][j] = getTotalDist(i, j);
			}
		}
	}

	/*
	*	start ---> start index
	*   end ---> end index
	*	remaining ---> remaining number of sections to select
	*/
	public int findMinByDfs(int start, int end, int remaining) {
		if(remaining == 1 && end == numHouses-1) {
			dp[start][remaining] = partialDistSum[start][end];
			return dp[start][remaining];
		}
		if(remaining == 0) return BIG; 
		if(start > end) return BIG;
		if(end >= numHouses) return BIG; 

		if(dp[start][remaining] == Integer.MAX_VALUE) {
			int includeThis = findMinByDfs(start, end+1, remaining);
			int excludeThis = partialDistSum[start][end] + findMinByDfs(end+1, end+1, remaining-1);
			dp[start][remaining] = includeThis < excludeThis ? includeThis : excludeThis;
		}

		return dp[start][remaining]; 
	}

	public int getMinTotalDistanceToTrashCans() {		
		return findMinByDfs(0, 0, numTrashCan); 
	}

	public static void main(String[] args) throws IOException {
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
			int numHouses = Integer.parseInt(tokenizer.nextToken()); 
			int numTrashCan = Integer.parseInt(tokenizer.nextToken()); 
			Solution solution = new Solution(numHouses, numTrashCan); 
			solution.readHouseLocs(); 
			solution.getPartialDistSum();
			System.out.println("Case #"+(i+1));
			System.out.println(solution.getMinTotalDistanceToTrashCans());
		} 
	}
}