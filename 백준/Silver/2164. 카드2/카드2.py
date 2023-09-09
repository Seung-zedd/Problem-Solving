from collections import deque

import sys  
input = sys.stdin.readline

N = int(input())
d = deque()

# 1~N번의 카드 생성
for x in range(1, N+1):
    d.append(x)

# 1), 2) 과정 반복
for _ in range(N-1):
    d.popleft()
    d.append(d.popleft())
print(*d)