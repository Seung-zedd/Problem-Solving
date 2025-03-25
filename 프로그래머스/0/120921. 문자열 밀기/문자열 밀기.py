from collections import deque
def solution(A, B):
    a = deque(A)
    b = deque(B)
    min_count = 0
    # 안 밀어도 B가 되는 경우
    if a == b:
        return 0
    # N번 밀어서 B가 되는 경우
    for i in range(1, len(A)):
        a.rotate(1)
        min_count += 1
        if a == b:
            return min_count
    return -1