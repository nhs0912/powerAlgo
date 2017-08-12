import java.util.Scanner;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in); 
	private int toSchool, toHome, totalDist, stepDist; 

	public Solution() {
		toSchool = scanner.nextInt(); 
		toHome = scanner.nextInt(); 
		totalDist = scanner.nextInt(); 
		stepDist = toSchool - toHome; 
	}

	public int solve() {
		int retval = 1; 
		int distMoved = toSchool; 
			
		do {
			distMoved += stepDist; 
			retval += 1; 
		} while (distMoved < totalDist); 
		
		return retval; 
	}

	public static void main(String[] args) {
		int numTestCases = scanner.nextInt(); 

		for(int i = 0; i < numTestCases; i++) {
			Solution sol = new Solution(); 
			System.out.println("Case #" + (i + 1)); 
			System.out.println(sol.solve());
		}
	}
}