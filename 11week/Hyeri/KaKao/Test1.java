
public class Test1 {
	//�� �ڸ����� �� ���ϱ�
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
