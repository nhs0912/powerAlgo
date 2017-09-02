class Solution {
    int solution(int[][] land) {
        int size = land.length; 
        int memo[][] = new int[size][4];
        
        int answer = 0;
        
        for(int row = size - 1; row >= 0; row--) {
            for(int pick = 0; pick < 4; pick++) {
                if(row == size - 1) 
                    memo[row][pick] = land[row][pick];
                else {
                    int subMax = 0; 
                    for(int nextPick = 0; nextPick < 4; nextPick++) {
                        if(nextPick == pick)
                            continue;
                        if(memo[row + 1][nextPick] > subMax)
                            subMax = memo[row + 1][nextPick]; 
                    }
                    memo[row][pick] = subMax + land[row][pick];
                }
            }
        }
        
        for(int i = 0; i < 4; i++) {
            if(memo[0][i] > answer)
                answer = memo[0][i];
        }
        return answer;
    }
}
