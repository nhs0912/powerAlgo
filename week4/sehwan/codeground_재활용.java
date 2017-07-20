import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 
import java.util.Arrays; 
import java.util.ArrayList; 

public class Solution {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public int[] houseLocs; 
	public int numHouses, numTrashCan; 
	public int lenSection, numLongSection; 
	public int[] maxSumIndexArray;
	public int maxSum;

	public Solution(int numHouses, int numTrashCan) {
		this.numHouses = numHouses; 
		this.numTrashCan = numTrashCan; 
		this.houseLocs = new int[numHouses];
		this.maxSumIndexArray = new int[numTrashCan];
		this.lenSection = numHouses / numTrashCan;
		this.numLongSection = numHouses % numTrashCan;
		this.maxSum = -1; 
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

	/* 
	* arr[] ---> Array of section length 
	* n ---> length of Array
	* running time: O( n )
	*/
	public int getTotalDistAtIndex(int[] arr, int n) {
		int sum = 0; 
		int dist, step, index = 0; 
		for(int i = 0; i < n-1; i++) {
			step = arr[i]; 
			index += step;
			dist = houseLocs[index] - houseLocs[index-1]; 
			sum += dist; 
		}

		return sum; 
	}

	/* 
	* arr[]  ---> Input Array
    * data[] ---> Temporary array to store current combination
    * start & end ---> Staring and Ending indexes in arr[]
    * index  ---> Current index in data[]
    * r ---> Size of a combination to be printed 
    */
    public void combinationHelper(int[] arr, int n, int r, int index,
                                int[] data, int i) {
        // Current combination is ready.
        if (index == r) {
        	// generate an array that represents the combination. 
        	int temp[] = new int[numTrashCan]; 
        	for(int j = 0; j < numTrashCan; j++) 
        		temp[j] = lenSection; 
            for(int j = 0; j < r; j++)
                temp[data[j]]++; 

            // check the total dist 
            int totalDist = getTotalDistAtIndex(temp, numTrashCan); 
            if(totalDist > maxSum) {
            	maxSum = totalDist; 
            	maxSumIndexArray = temp; 
            }
        	return;
        }
 
        // When no more elements are there to put in data[]
        if (i >= n)
        	return;
 
        // current is included, put next at next location
        data[index] = arr[i];
        combinationHelper(arr, n, r, index+1, data, i+1);
 
        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationHelper(arr, n, r, index, data, i+1);
    }
 
    /*
    * The Solution function that finds all combinations C(n,k).
    * in arr[] of size n. This function Solutionly uses combinationHelper()
    * O( C(n, k)) 
    */
    public void getCombination(int n, int r) {
    	int[] arr = new int[n]; 
    	for(int i = 0; i < n; i++) 
    		arr[i] = i; 

        // A temporary array to store all combination one by one
        int[] data = new int[r];
 
        // Print all combination using temprary array 'data[]'
        combinationHelper(arr, n, r, 0, data, 0);
    }

	
	/*
	*	Needs implementation 
	*/
	public int getMinTotalDistanceToTrashCans() {
		int step, index = 0, sum = 0; 
		getCombination(numTrashCan, numLongSection); 
		for(int i = 0; i < numTrashCan; i++) {
			step = maxSumIndexArray[i]; 
			sum += getTotalDist(index, index+step-1); 
			index += step; 
		}
		return sum; 
	}

	public static void Solution(String[] args) throws IOException {
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