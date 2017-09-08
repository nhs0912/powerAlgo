
public class Test1 {
	//각 자릿수의 합 구하기
	public static void main(String[] args) {
		int n =10;
		
		System.out.println(solution(987)); 

	}
	
	public static int solution(int n) {
		int answer = 0;
		String number = String.valueOf(n);
		int length = number.length();
		
		for(int i=0; i<length; i++){
			answer += (n / (int)Math.pow(10, length-i-1));
			n = n % (int)Math.pow(10, length-i-1);
		}
		return answer;
	}
}
