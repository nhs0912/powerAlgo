// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        final int upperBound = 1000000000;
        int len = A.length;
        
        int prev = Integer.MIN_VALUE; 
        int answer = 0; 
        int sliceSize = 0;
        
        for(int i = 0; i < len - 1; i++) {
            int diff = A[i + 1] - A[i]; 
            if(diff != prev) {
                answer += (sliceSize - 1) * sliceSize / 2;
                if(answer > upperBound)
                    return -1; 
                sliceSize = 1;
            } else {
                sliceSize++; 
            }
            prev = diff;
        }
        answer += (sliceSize - 1) * sliceSize / 2;
                
        return answer;
    }
}