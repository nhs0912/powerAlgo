import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 
import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.Comparator;

public class Solution {
	private class MyDist { 
		public int dist; 
		public int index; 
		public MyDist(int dist, int index) {
			this.dist = dist; 
			this.index = index; 
		}
	}

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public int[] houseLocs, rmIndex;
	public int numHouses, numTrashCan; 

	public Solution(int numHouses, int numTrashCan) {
		this.numHouses = numHouses; 
		this.numTrashCan = numTrashCan; 
		this.houseLocs = new int[numHouses];
		this.rmIndex = new int[numTrashCan]; 
		this.rmIndex[numTrashCan-1] = numHouses-1;
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
	
	public void getRmIndex() {
		MyDist[] houseDists = new MyDist[numHouses-1];

		for(int i = 0; i < numHouses-1; i++) {
			houseDists[i] = new MyDist(houseLocs[i+1] - houseLocs[i], i);
		}
		// sort by dist desc
		Arrays.sort(houseDists, new Comparator<MyDist> (){
			@Override 
			public int compare(MyDist o1, MyDist o2) {
				if(o1.dist < o2.dist) 
					return 1; 
				else if(o1.dist > o2.dist)
					return -1; 
				else 
					return 0; 
			}
		});

		for(int i = 0; i < numTrashCan-1; i++) {
			rmIndex[i] = houseDists[i].index; 
		}

		Arrays.sort(rmIndex); 
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
	/*
	*	Needs implementation 
	*/
	public int getMinTotalDistanceToTrashCans() {
		int dist, index = 0, sum = 0; 
		getRmIndex(); 
		if(numTrashCan < 2) {

		}
		for(int i = 0; i < numTrashCan; i++) {
			dist = getTotalDist(index, rmIndex[i]); 
			index = rmIndex[i]+1; 
			sum += dist; 
		}
		return sum; 
	}

	public static void main(String[] args) throws IOException {
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
			int numHouses = Integer.parseInt(tokenizer.nextToken()); 
			int numTrashCan = Integer.parseInt(tokenizer.nextToken()); 
			Solution solution = new Solution(numHouses, numTrashCan); 
			solution.readHouseLocs(); 
			System.out.println("Case #"+(i+1));
			System.out.println(solution.getMinTotalDistanceToTrashCans());
		} 
	}
}