import numpy as np

def solution(v):
    answer = []
    
    v = np.array(v) 
    
    vector1 = v[0] - v[1]
    vector2 = v[1] - v[2]
    vector3 = v[2] - v[0]

    if np.dot(vector1, vector2) == 0:
        answer.extend(v[2] + vector1)
    elif np.dot(vector2, vector3) == 0:
        answer.extend(v[0] + vector2)
    elif np.dot(vector3, vector1) == 0: 
        answer.extend(v[1] + vector3)
    
    return answer