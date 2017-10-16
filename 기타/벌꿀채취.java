import java.util.Scanner;
import java.util.Arrays; 

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);
	private int testCaseNum, mapSize, numPick, maxWeight, honeyMap[][], profitMap[][]; 

	public Solution(int testCaseNum) {
		this.testCaseNum = testCaseNum; 
		this.mapSize = scanner.nextInt(); 
		this.numPick = scanner.nextInt(); 
		this.maxWeight = scanner.nextInt(); 

		this.honeyMap = new int[this.mapSize][this.mapSize]; 
		this.profitMap = new int[this.mapSize][this.mapSize - this.numPick + 1];

		for(int i = 0; i < this.mapSize; i++) {
			for(int j = 0; j < this.mapSize; j++) {
				this.honeyMap[i][j] = scanner.nextInt(); 
			}
		}
	}

	private int getMaxProfit(int[] honeys, int index, int profit, int sumWeight, int currMax) {
		if(sumWeight > this.maxWeight) 
			return 0; 

		currMax = Math.max(currMax, profit); 

		if(index == this.numPick) {
			return currMax; 
		}
		int opt1 = getMaxProfit(honeys,
		 						index + 1, 
		 						profit + (honeys[index] * honeys[index]), 
		 						sumWeight + honeys[index], 
		 						currMax); 
		int opt2 = getMaxProfit(honeys, 
								index + 1, 
								profit, 
								sumWeight, 
								currMax); 

		return Math.max(opt1, opt2); 
	}

	public void fillMaxProfitMap() {
		for(int i = 0; i < this.mapSize; i++) {
			for(int j = 0; j < this.mapSize - this.numPick + 1; j++) {
				int[] honeys = Arrays.copyOfRange(this.honeyMap[i], j, j + numPick); 
				this.profitMap[i][j] = getMaxProfit(honeys, 0, 0, 0, 0); 
			}
		}
	}

	public int getMaxProfitPair() {
		int max = 0; 

		for(int i = 0; i < this.mapSize; i++) {
			for(int j = 0; j < this.mapSize - this.numPick + 1; j++) {
				for(int k = i; k < i + 1; k++) {
					for(int l = j + numPick; l < this.mapSize - this.numPick + 1; l++) {
						max = Math.max(max, profitMap[i][j] + profitMap[k][l]);
					}
				}

				for(int k = i + 1; k < this.mapSize; k++) {
					for(int l = 0; l < this.mapSize - this.numPick + 1; l++) {
						max = Math.max(max, profitMap[i][j] + profitMap[k][l]);
					}
				}
			}
		}

		return max; 
	}

	public void solve() {
		fillMaxProfitMap(); 
		System.out.println("#" + this.testCaseNum + " " + getMaxProfitPair()); 
	}

	public static void main(String[] args) {
		int T = scanner.nextInt(); 

		for(int i = 0; i < T; i++) {
			Solution sol = new Solution(i + 1); 
			sol.solve(); 
		}
	}
}