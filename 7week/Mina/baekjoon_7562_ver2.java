import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	static boolean visitedCheck[][];
	static int Answer;
	static int T, N;
	static int startX, startY, endX, endY;
	static int Dx[] = new int[]{2,2,-2,-2,1,1,-1,-1}; 
	static int Dy[] = new int[]{1,-1,1,-1,2,-2,2,-2};

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt(); // 테스트케이스 개수
		
		for(int t = 1; t <= T; t++) {		
			
			Queue<int[]> queue = new LinkedList<>();
			
			N = sc.nextInt(); // 체스판 한 변의 크기
			
			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();
			
			visitedCheck = new boolean[N][N];
			
			
			queue.add(new int[]{startX, startY, 0});
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visitedCheck[i][j] = false;
				}
			}
			
			visitedCheck[startX][startY] = true;
			
			while(!queue.isEmpty()) {
				int currIndex[] = queue.poll();
				
				if(currIndex[0] == endX && currIndex[1] == endY)
				{
					Answer = currIndex[2];
					break;
				}
				
				int checkX, checkY;
				for(int i = 0; i < 8; i++) {
					
					checkX = currIndex[0] + Dx[i];
					checkY = currIndex[1] + Dy[i];
					
					if(checkX >= N || checkX < 0 || checkY >= N || checkY < 0)
						continue;
					
					if(visitedCheck[checkX][checkY])
						continue;
					
					visitedCheck[checkX][checkY] = true;
					queue.add(new int[]{checkX, checkY, currIndex[2]+1});
				}

			}
			System.out.println(Answer);
		}
	}
}
