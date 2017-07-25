import java.util.Scanner; 
import java.util.Arrays; 
import java.util.Comparator; 

public class Solution {
	private static Scanner scanner = new Scanner(System.in); 
	private int numSubject, numToStudy; 
	private Integer nums[]; 

	public Solution () {
		readAndInit(); 
	}

	private void readAndInit() {
		numSubject = scanner.nextInt(); 
		numToStudy = scanner.nextInt(); 
		nums = new Integer[numSubject]; 

		for(int i = 0; i < numSubject; i++) 
			nums[i] = scanner.nextInt(); 

		Arrays.sort(nums, new Comparator<Integer> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1); 
			}
		}); 
	}

	public int getMaxTestSum() {
		int sum = 0; 
		for(int i = 0; i < numToStudy; i++){
			sum += nums[i];
		}

		return sum; 
	}

	public static void main(String[] args) {
		int numTestCases = scanner.nextInt(); 

		for(int i = 0; i < numTestCases; i++) {
			Solution sol = new Solution(); 
			System.out.println("Case #" + (i+1)); 
			System.out.println(sol.getMaxTestSum()); 
		}
	}
}