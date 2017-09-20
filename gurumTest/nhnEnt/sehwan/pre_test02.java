import java.util.Scanner; 
import java.util.stream.*; 

class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private Integer size, matrix[][]; 

	public Main() {
		this.size = scanner.nextInt(); 
		this.matrix = new Integer[size][size]; 
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				matrix[j][i] = scanner.nextInt(); 
			}
		}
	} 
	
	private void printMatrix() { 
		for(int i = 0; i < this.size; i++) {
			String lineString = Stream.of(matrix[i])
								.map(num->Integer.toString(num))
								.collect(Collectors.joining(" "));
			System.out.println(lineString);
		}
	}

	public void solve() {
		printMatrix(); 
	}
	
  public static void main(String[] args) {
		Main main = new Main(); 
		main.solve();
	}
}
