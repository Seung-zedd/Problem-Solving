from collections import deque

def solution(numbers, direction):
    q = deque(numbers)
    q.rotate(-1 if direction == "left" else 1)
    
    return list(q)