import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.Scanner; 

public class Main {
	// public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static Scanner scanner = new Scanner(System.in); 
	public int   size;
	// space complexity: O(n) 
	public int[] nums;

	public Main(int size) {
		this.size = size; 
		nums = new int[size];
	}

	public void readNums() throws IOException {
		for(int i = 0; i < size; i++) {
			nums[i] = scanner.nextInt(); 
		}
	}

	public int getMaxSum() {
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + nums[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;	
	}

	public static void main(String[] args) throws IOException {
		int size = scanner.nextInt(); 
		Main main = new Main(size); 
		main.readNums() ; 
		System.out.println(main.getMaxSum()); 
		scanner.close();
	}
}