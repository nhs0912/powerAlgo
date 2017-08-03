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

	private int min(int n1, int n2, int n3) {
		int min = Integer.MAX_VALUE;
		if(n1 < min && n1 > 0)
			min = n1;  
		if(n2 < min && n2 > 0) 
			min = n2;
		if(n3 < min && n3 > 0)
			min = n3;
		return min; 
	}

	private int helper(int n) {
		if(n <= 1)
			return 0; 
		if(n == 2 || n == 3)
			return 1; 

		int n1 = 0, n2 = 0, n3; 
		if(memo[n] == 0) {
			if(n % 3 == 0) 
				n1 = n / 3; 
			if(n % 2 == 0)
				n2 = n / 2; 
			n3 = n - 1;
			memo[n] = 1 + min(helper(n1), helper(n2), helper(n3)); 
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