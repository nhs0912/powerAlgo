import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in); 
	private String word; 
	private int size, palindromeMap[][], minPlindromeMap[];

	public Main() {
		this.word = scanner.next(); 
		this.size = word.length();
		this.palindromeMap = new int[size][size];
		this.minPlindromeMap = new int[size];

		for(int i = 0; i < this.size; i++) {
			this.minPlindromeMap[i] =  -1; 
			for(int j = 0; j < this.size; j++) {
				this.palindromeMap[i][j] = -1;
			}
		}
	}

	private boolean isPalindrome(int start, int end) {
		if(start >= end) 
			this.palindromeMap[start][end] = 1;
			 
		
		if(this.palindromeMap[start][end] < 0) {
			if (isPalindrome(start + 1, end - 1) 
				&& word.charAt(start) == word.charAt(end)) {
				this.palindromeMap[start][end] = 1;
			} else {
				this.palindromeMap[start][end] = 0; 
			}
		}

		return this.palindromeMap[start][end] == 1 ? true : false;
	}

	private int getMinNumPalindrome(int start) {
		if(start >= size)
			return 0;

		if(minPlindromeMap[start] < 0) {
			int answer = Integer.MAX_VALUE; 
			for(int i = start; i < size; i++) {
				if(palindromeMap[start][i] == 1) {
					int altNum = 1 + getMinNumPalindrome(i + 1);
					answer = answer < altNum ? answer : altNum; 
				}
			}
			minPlindromeMap[start] = answer; 
		}
		
		return minPlindromeMap[start];
	}

	private void fillPalindromeMap() {
		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				isPalindrome(i, j);
			}
		}	
	}

	public void solve() {
		fillPalindromeMap(); 
		System.out.println(getMinNumPalindrome(0));
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve();
	}
}