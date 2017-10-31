// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, String S) {
        // write your code in Java SE 8
        int[] checkList = {0, 4, 5, 9}; 
        boolean[][] seatMap = new boolean[N][12]; 
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 12; j++) {
                if (j != 3 || j != 8) 
                    seatMap[i][j] = false; 
                else 
                    seatMap[i][j] = true; 
            }
        }
        if(S.equals("")) 
            return N * 3; 
            
        for(String reserved : S.split("\\s+")) {
            String row = "0"; 
            String col = ""; 
                        
            for (int i = 0; i < reserved.length(); i++) {
                if(Character.isLetter(reserved.charAt(i))) 
                    col += reserved.charAt(i); 
                else 
                    row += reserved.charAt(i);
            }
            int r = Integer.parseInt(row) - 1; 
            int c = 0; 
            
            if(col.equals("A")) 
                c = 0; 
            else if(col.equals("B"))
                c = 1; 
            else if(col.equals("C"))
                c = 2; 
            else if(col.equals("D"))
                c = 4; 
            else if(col.equals("E")) 
                c = 5; 
            else if(col.equals("F"))
                c = 6; 
            else if(col.equals("G"))
                c = 7; 
            else if(col.equals("H"))
                c = 9; 
            else if(col.equals("J"))
                c = 10; 
            else if(col.equals("K"))
                c = 11;
            
            
            seatMap[r][c] = true;
        }
        
        int count = 0; 
        for(int i = 0; i < N; i++) {
            for(int j : checkList) {
                if(!seatMap[i][j] && !seatMap[i][j+1] && !seatMap[i][j+2]){
                    seatMap[i][j + 1] = true ;
                    count++;
                }
            }
        }
        
        return count; 
    }
}