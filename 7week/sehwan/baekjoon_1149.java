import java.util.Scanner; 

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private int n, cost[][], memo[][]; 

	public Main() {
		n = scanner.nextInt(); 
		cost = new int[n][3]; 
		memo = new int[n][3]; 

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				cost[i][j] = scanner.nextInt(); 
				memo[i][j] = 0; 
			}
		}
	}	

	private int min(int num1, int num2) {
		return num1 < num2 ? num1 : num2; 
	}

	private int min(int num1, int num2, int num3) {
		return min(min(num1, num2), num3); 
	}

	private int getMinCost(int curr, int color) {
		if(memo[curr][color] == 0){
			if(curr == n - 1) 
				memo[curr][color] = cost[curr][color];
			else {
				if(color == 0) 
					memo[curr][color] = cost[curr][color] + min(getMinCost(curr + 1, 1), getMinCost(curr + 1, 2)); 
				if(color == 1)
					memo[curr][color] = cost[curr][color] + min(getMinCost(curr + 1, 0), getMinCost(curr + 1, 2));
				if(color == 2) 
					memo[curr][color] = cost[curr][color] + min(getMinCost(curr + 1, 0), getMinCost(curr + 1, 1));
			}
		}
		 
		return memo[curr][color]; 
	}

	public void solve() { 
		System.out.println(min(getMinCost(0, 0), getMinCost(0, 1), getMinCost(0, 2))); 
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.solve(); 
	}	
}