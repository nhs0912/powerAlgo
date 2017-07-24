import java.util.Scanner; 

public class Main{
	private static Scanner scanner = new Scanner(System.in); 
	private int arrayLength; 
	private int nums[];
	private char dp[][];

	public Main() {
		readAndInit();
	} 

	private void readAndInit() {
		arrayLength = scanner.nextInt();
		nums = new int[arrayLength];

		for(int i = 0; i < arrayLength; i++) {
			nums[i] = scanner.nextInt(); 
		}

		dp = new char[arrayLength][arrayLength]; 

		for(int i = 0; i < arrayLength; i++) {
			for(int j = 0; j < arrayLength; j++) {
				dp[i][j] = 0;
			}
		}

		int numTestCase = scanner.nextInt(); 
		int start, end; 
		for(int i = 0; i < numTestCase; i++ ) {
			start = scanner.nextInt() -1; 
			end  = scanner.nextInt() -1; 
			System.out.println(isPalindrome(start, end)); 
		}
	}

	private char isPalindrome(int start, int end) {
		if(start >= end) return '1'; 

		if(dp[start][end] > 0) return dp[start][end]; 

		if(nums[start] != nums[end])
			dp[start][end] = (char) '0'; 
		else
			dp[start][end] = isPalindrome(start+1, end-1);
		return dp[start][end];
	}

	public static void main(String[] args) {
		Main main = new Main();
	}
}