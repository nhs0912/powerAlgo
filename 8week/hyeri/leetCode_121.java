public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i =0; i <prices.length-1; i++){
           if( -prices[i] + findMax(i, prices) > max){
               max=-prices[i] + findMax(i, prices);
           } 
        }
        return max;
    }
    
    public int findMax(int index, int[] prices){
        int result = 0;
        for(int i =index+1; i <prices.length; i++){
            if(prices[i] > prices[index] && result < prices[i]){
                result = prices[i];
            }
        }
        return result;
    }
}