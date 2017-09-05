class Solution {
    public int[] solution(int[][] v) {
       
        int[] x1 = {v[0][0], v[1][0], v[2][0]};
        int[] y1 = {v[0][1], v[1][1], v[2][1]};
        int x2 = 0, y2 = 0;
        
        if(x1[0]==x1[1]){
            x2 = x1[2];
        }else if(x1[1]==x1[2]){
            x2 = x1[0];
        }else{
            x2 = x1[1];
        }
        
        if(y1[0]==y1[1]){
            y2 = y1[2];
        }else if(y1[1]==y1[2]){
            y2 = y1[0];
        }else{
            y2 = y1[1];
        }
        
        
        int[] answer = {x2, y2};
        
        return answer;
    }
}
