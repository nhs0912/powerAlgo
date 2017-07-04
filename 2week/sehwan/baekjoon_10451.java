import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Permutation {
	public int[] nums; 
	public boolean[] visited; 
	public int size; 

	public Permutation (int size) {
		nums = new int[size]; 
		visited = new boolean[size];  
		this.size = size;
	}

	public void setNums(BufferedReader reader) throws IOException {
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 

		int i = 0; 
		while(tokenizer.hasMoreTokens()) {
			nums[i++] = Integer.parseInt(tokenizer.nextToken()); 
		}
	}

	public int countNumCycle() {
		int count = 0;

		for(int i = 0; i < size; i++) {
			visited[i] = false;
		}

		for(int i = 0; i < size; i++) {
			if (visited[i]) {
				continue; 
			}
			
			int index = i; 
			while (!visited[index]) {
				visited[index] = true; 
				index = nums[index]-1; 
			}
			count++;
		}
		return count; 
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

		int numTestCase = Integer.parseInt(reader.readLine());

		for(int i = 0; i < numTestCase; i++) {
			int arraySize = Integer.parseInt(reader.readLine()); 
			Permutation permutation = new Permutation(arraySize);
			permutation.setNums(reader);
			int numCycle = permutation.countNumCycle(); 
			System.out.println(numCycle);
		} 
	}
}