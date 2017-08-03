import java.util.Scanner;

class Main {
	public static final Scanner scanner = new Scanner(System.in); 
	public int num, memo[]; 

	public Main() {
		this.num = scanner.nextInt(); 
		this.memo = new int[num + 1]; 
		for(int i = 0; i < num + 1; i++) {
			memo[i] = 0; 
		}
	}

	private int helper(int n) {
		if(n <= 1)
			return 0; 
		if(n == 2 || n == 3)
			return 1; 

		int temp, min = Integer.MAX_VALUE; 
		if(memo[n] == 0) {
			if(n % 3 == 0) {
				temp = helper(n / 3);
				min = min < temp ? min : temp; 
			}
			if(n % 2 == 0) {
				temp = helper(n / 2);
				min = min < temp ? min : temp; 
			}
			temp = helper(n - 1); 
			min = min < temp ? min : temp; 
			memo[n] = 1 + min; 
		}

		return memo[n];
	}

	private int answer() { 
		return helper(num); 
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		System.out.println(main.answer());
	}
}