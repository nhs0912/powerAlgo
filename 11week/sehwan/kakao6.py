import numpy as np

def getMaxNoCircle(nums): 
    size = nums.size
    
    if size == 0:
        return 0
    
    memo = np.zeros(size)
    
    for i in range(size - 1, -1, -1): 
        if i == size - 1:
            memo[i] = nums[i]
        elif i == size - 2:
            memo[i] = max(nums[i], memo[i + 1])
        elif i == size - 3: 
            opt1 = nums[i] + memo[i + 2]
            opt2 = memo[i + 1] 
            memo[i] = max(opt1, opt2) 
        else:
            opt1 = nums[i] + memo[i + 2]
            opt2 = nums[i + 1] + memo[i + 3] 
            memo[i] = max(opt1, opt2)
        
    return memo[0]

def solution(sticker):
    answer = 0
    sticker = np.array(sticker)
    size = sticker.size
    if size == 1: 
        return sticker[0]
    sticker1 = sticker[  : size - 1]
    sticker2 = sticker[1 : size]
    
    answer = max(getMaxNoCircle(sticker1), getMaxNoCircle(sticker2))
    
    return answer
