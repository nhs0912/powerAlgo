import numpy as np
    
def solution(board):
    answer = 0 
    board = np.array(board)
    max_size_map = np.zeros(board.shape)
    
    for i in range(board.shape[0] - 1, -1, -1):
        for j in range(board.shape[1] - 1, -1, -1): 
            if board[i, j] == 1: 
                if i == board.shape[0] - 1 or j == board.shape[1] - 1: 
                    max_size_map[i, j] = board[i, j] 
                else: 
                    max_size_map[i, j] = min(max_size_map[i+1, j]
                                            ,max_size_map[i, j+1]
                                            ,max_size_map[i+1, j+1]) + 1
    
                answer = max(answer, max_size_map[i,j])
    return answer ** 2