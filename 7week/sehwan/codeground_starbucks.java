import java.util.Scanner; 

public class Solution {
	private static final Scanner scanner = new Scanner(System.in); 
	private int numPeople, numCoffees, maxPrice, coffeePrice[], coffeePreference[]; 

	public Solution() {
		numPeople = scanner.nextInt();
		numCoffees = scanner.nextInt();
		maxPrice = scanner.nextInt(); 

		coffeePrice = new int[numCoffees];
		coffeePreference = new int[numPeople];

		for(int i = 0; i < numPeople; i++){
			coffeePreference[i] = scanner.nextInt() - 1; 
		}

		for(int i = 0; i < numCoffees; i++){
			coffeePrice[i] = scanner.nextInt(); 
		}
	}

	public void solve() {
		int totalPrice = 0; 

		for(int i = 0; i < numPeople; i++) {
			totalPrice += coffeePrice[coffeePreference[i]]; 
		}

		if(totalPrice > maxPrice)
			System.out.println('N'); 
		else
			System.out.println('Y');
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