class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxSoFar = 0
        answer = 0 
        prices.reverse();
        for price in prices: 
            maxSoFar = max(price, maxSoFar) 
            answer = max(answer, maxSoFar - price)
        return answer
            
        