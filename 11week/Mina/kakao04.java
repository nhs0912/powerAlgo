class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int x = board.length;
        int y = board[0].length;
     
        int[][] map = new int[x+1][y+1];
        for(int i = 1; i<x+1; i++){
            for(int j = 1; j<y+1; j++){
                map[i][j] = board[i-1][j-1];
            }
        }
        int[][] dp = new int[x+1][y+1];
        
        for(int i =1; i<x+1; i++){
            for(int j = 1; j<y+1; j++){
                if(map[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        answer*=answer;
        return answer;
    }
}

/*

0 1 1 1
1 1 1 1
1 1 1 1
0 0 1 0

*/
