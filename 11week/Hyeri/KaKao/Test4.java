
public class Test4 {
	//가장 큰 직사각형  넓이 출력

	public static void main(String[] args) 	{
		int [][] board = {{0,1,0,0},{0,1,1,1},{1,1,1,0},{0,0,1,0}};
		System.out.println(solution(board));
	}
	
	 public static int solution(int [][]board)
	    {
	        int answer = 0;
	        int dp[][] = new int[board.length][board[0].length];
	  
	        for(int i =0; i < board.length; i++){
	        	for(int j =0; j < board[0].length; j++){
	        		dp[i][j] = board[i][j];
	        	}
	        }
	        
	        
	        for(int i =1; i < board.length; i++){
	        	for(int j =1; j < board[0].length; j++){
	        		if(board[i][j]==1){
	        			dp[i][j] = Min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1;
	        			answer = answer > dp[i][j] ? answer : dp[i][j]; 
	        		}
	        	}
	        }
	        
	        for(int i =0; i < board.length; i++){
	        	answer = answer > dp[i][0] ? answer : dp[i][0]; 
	        }
	        
	        for(int i =0; i < board[0].length; i++){
    			answer = answer > dp[0][i] ? answer : dp[0][i]; 
	        }

	        return answer*answer;
	    }
	 
	 public static int  Min(int a, int b, int c){
		 a = a < b ? a: b;
		 return a <c ? a : c;
	 }
}
