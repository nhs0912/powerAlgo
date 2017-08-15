import java.util.Scanner;

class Solution {
	static int Answer;
	static int goDistance;
	static int backDistance;
	static int distance;
	
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer =1;
			goDistance = sc.nextInt();// 학교로 이동하는 거리
			backDistance = sc.nextInt();// 집으로 이동 거리
			distance = sc.nextInt();// 집 - 학교 거리
			
			if((distance-goDistance)%(goDistance-backDistance) !=0){
				Answer += ((distance-goDistance)/(goDistance-backDistance))+1;
			}else{
				Answer += ((distance-goDistance)/(goDistance-backDistance));
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
}