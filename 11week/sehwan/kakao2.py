def solution(arr):
    max_num = 0 
    sum_num = 0 
    
    for num in arr: 
        max_num = max(max_num, num)
        sum_num += num 
    
    expected_sum = (max_num * (max_num + 1)) / 2
    
    if expected_sum != sum_num:
        return False 
    
    return True