from collections import deque

def solution(strs, t):
    answer = 20000
    
    word_dict = {}
    already_taken = {}
    for string in strs: 
        if string[0] not in word_dict: 
            word_dict[string[0]] = [string]
        else: 
            word_dict[string[0]].append(string)
    word_end = len(t)
    queue = deque([(0, 0)])
    
    while queue:
        curr = queue.popleft()
        curr_word_start = curr[0]
        curr_cnt = curr[1]
        
        if curr_word_start >= word_end:
            answer = min(answer, curr_cnt)
            break
            
        if t[curr_word_start] in word_dict: 
            word_length = word_end - curr_word_start
            frag_list = word_dict[t[curr_word_start]] 
            
            for frag in frag_list: 
                frag_length = len(frag)     
                if frag_length <= word_length: 
                    next_start = curr_word_start + frag_length
                    if frag == t[curr_word_start : next_start]:
                        if next_start not in already_taken:
                            queue.append((next_start, curr_cnt + 1))
                            already_taken[next_start] = True
                
    if answer == 20000:
        return -1 
    return answer