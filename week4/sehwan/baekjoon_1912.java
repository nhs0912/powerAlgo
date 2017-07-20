import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 

public class Main {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public int   size;
	// Space Complexity: O(n^2) 
	public int[] nums;
	public int[][] sums; 

	public Main(int size) {
		this.size = size; 
		nums = new int[size];
		sums = new int[size][size];
	}

	public void readNums() throws IOException {
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int i = 0;
		while(tokenizer.hasMoreTokens()) {
			nums[i++] = Integer.parseInt(tokenizer.nextToken());
		}
		
	}

	private int getSum(int start, int end) {
		if(start > end) return 0; 
		if(sums[start][end] < Integer.MAX_VALUE) {

		} else {
			sums[start][end] = nums[start] + getSum(start+1, end); 
		}

		return sums[start][end]; 
	}

	// Time Complexity: O(n^2) 
	public int getMaxSum() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				sums[i][j] = (i == j) ?  nums[i] : Integer.MAX_VALUE; 
			}
		}

		int index = 0;
		int sum;
		int max = 0; 

		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				sum = getSum(i, j); 
				max = max > sum ? max : sum; 
			}
		}
		return max; 	
	}

	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(reader.readLine()); 
		Main main = new Main(size); 
		main.readNums() ; 
		System.out.println(main.getMaxSum()); 
	}
}