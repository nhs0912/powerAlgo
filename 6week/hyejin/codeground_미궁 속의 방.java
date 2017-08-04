import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int test_case;

		for (test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt();	//격자크기
			int K = sc.nextInt();	//경근이가 움직인 횟수
			sc.nextLine();
			String str = sc.nextLine();
			int[][] arr = new int[N][N];
			
			int sum = 1;
			int x = 0, y = 0, num = 0;

			for (int i=0; i<N; i++) {
				arr[x][y] = ++num;
				while (x > 0) 
					arr[--x][++y] = ++num;			
				y++;
				if(y == N) break;
				
				arr[x][y] = ++num;
				while (y > 0) 
					arr[++x][--y] = ++num;				
				x++;
				if(x == N) break;
			}
			
			x = N-1; y = N-1; num = N*N;
			
			for (int i=N; i>1; i--) {
				arr[x][y] = num--;
				while (x < N-1) 
					arr[++x][--y] = num--;
				--y;
				if(y == 0) break;
			
				arr[x][y] = num--;
				while (y < N-1)
					arr[--x][++y] = num--;
				--x;
				if(x == 0) break;
			}
			
			x = 0; y = 0;
			
			for(int i=0; i<K; i++){
				if(str.charAt(i) == 'D')
					sum += arr[++x][y];
				else if(str.charAt(i) == 'R')
					sum += arr[x][++y];
				else if(str.charAt(i) == 'U')
					sum += arr[--x][y];
				else if(str.charAt(i) == 'L')
					sum += arr[x][--y];
			}
			
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		}
	}
}
