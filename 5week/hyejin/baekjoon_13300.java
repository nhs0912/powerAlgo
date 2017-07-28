import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();	//수학여행에 참가하는 학생 수
		int K = sc.nextInt();	//배정가능한 최대 인원 수
		int S, Y;
		int[] cnt = new int[12];
		int room = 0;
		
		for(int i=0; i<N; i++) {
			S = sc.nextInt();	//학생의 성별
			Y = sc.nextInt();	//학생의 학년
			
			if (S==0) {
				cnt[Y*2-1] += 1;
				if(cnt[Y*2-1] % K == 1)
					room++;
			} else {
				cnt[Y*2-2] += 1;
				if(cnt[Y*2-2] % K == 1)
					room++;
			}
		}
		
		System.out.println(room);
	}
}
