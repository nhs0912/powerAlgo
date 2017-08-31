class Solution(object):
    def nextPermutation(self, curr):
        retval = list(curr)
        
        end = len(retval) - 1
        i = end
        j = i - 1

        while retval[j] > retval[i]:
            if j == 0:
                return [-1]
            j -= 1
            i -= 1

        while not (retval[end] > retval[j]):
            end -= 1

        retval[end], retval[j] = retval[j], retval[end]
        retval[j + 1:] = reversed(retval[j + 1:])
        return retval

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        ans = [nums]
        temp = list(nums)

        if nums.__len__() > 1: 
            return ans 
            
        while True: 
            temp = self.nextPermutation(temp)
            if temp == [-1]:
                break
            ans.append(temp)
        return ans
        