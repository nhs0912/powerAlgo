def solution(n):
    answer = 0
    while n > 0:
        digit = n % 10 
        answer += digit
        n -= digit
        n /= 10 
    return answer