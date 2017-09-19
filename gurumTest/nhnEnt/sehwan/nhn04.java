import java.util.Scanner; 
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque; 
import java.util.ArrayDeque;  
import java.util.stream.*; 

public class Main { 
	private class DescComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer n1, Integer n2) {
			Deque<Integer> digits1 = new ArrayDeque<Integer>();
			Deque<Integer> digits2 = new ArrayDeque<Integer>(); 

			while(n1 > 0) {
				digits1.addFirst(n1 % 10); 
				n1 /= 10; 
			}

			while(n2 > 0) { 
				digits2.addFirst(n2 % 10); 
				n2 /= 10; 
			}

			Integer leftMostDigit1 = digits1.peekFirst();
			Integer leftMostDigit2 = digits2.peekLast();

			while(true) {
				Integer d1 = digits1.pollFirst(); 
				Integer d2 = digits2.pollFirst(); 
				
				if(d1 == null && d2 == null){
					return 0; 
				} else if(d1 == null && d2 != null) {
					if(d2 < leftMostDigit1) 
						return 1; 
					else 
						return -1; 
				} else if(d1 != null && d2 == null) { 
					if(d1 < leftMostDigit2) 
						return -1;
					else 
						return 1;
				} else {
					if(d1 > d2) 
						return 1; 
					else if(d1 < d2) 
						return -1; 
				}
			}
		}
	}

	private class AscComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer n1, Integer n2) {
			Deque<Integer> digits1 = new ArrayDeque<Integer>();
			Deque<Integer> digits2 = new ArrayDeque<Integer>(); 

			while(n1 > 0) {
				digits1.addFirst(n1 % 10); 
				n1 /= 10; 
			}

			while(n2 > 0) { 
				digits2.addFirst(n2 % 10); 
				n2 /= 10; 
			}

			Integer leftMostDigit1 = digits1.peekFirst();
			Integer leftMostDigit2 = digits2.peekLast();

			if(leftMostDigit1 == 0) {
				return 1; 
			}

			if(leftMostDigit2 == 0) {
				return -1; 
			}

			while(true) {
				Integer d1 = digits1.pollFirst(); 
				Integer d2 = digits2.pollFirst(); 
				
				if(d1 == null && d2 == null){
					return 0; 
				} else if(d1 == null && d2 != null) {
					if(d2 < leftMostDigit1) 
						return -1; 
					else 
						return 1; 
				} else if(d1 != null && d2 == null) { 
					if(d1 < leftMostDigit2) 
						return 1;
					else 
						return -1;
				} else {
					if(d1 > d2) 
						return -1; 
					else if(d1 < d2) 
						return 1; 
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in); 
	private int size;
	private ArrayList<Integer> numbers; 

	public Main() { 
		this.size = scanner.nextInt(); 
		this.numbers = new ArrayList<> (); 

		for(int i = 0; i < size; i++) {
			numbers.add(scanner.nextInt()); 
		}
	}

	private int appendAllIntegers(ArrayList<Integer> nums) { 
		return Integer.parseInt(nums.stream()
									.map(i -> i.toString())
									.collect(Collectors.joining())
									); 
	}

	private int getMaxNum(ArrayList<Integer> nums) {
		Collections.sort(nums, new DescComparator());
		return appendAllIntegers(nums);
	}

	private int getMinNum(ArrayList<Integer> nums) {
		Collections.sort(nums, new AscComparator()); 
		return appendAllIntegers(nums); 
	}

	private int getMaxSum(ArrayList<Integer> nums) {
		return getMaxNum(nums) + getMinNum(nums);  
	}

	public void solve() {
		System.out.println(getMaxSum(this.numbers)); 
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve(); 
	}
}