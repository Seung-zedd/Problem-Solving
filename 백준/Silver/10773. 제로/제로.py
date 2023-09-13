import sys
input = sys.stdin.readline

N = int(input()) # 테스트 케이스 개수
stack = []

for _ in range(N):
    a = int(input())
    
    if a == 0: # 0을 외치면
        stack.pop()
    else:
        stack.append(a)
if stack:
    sum = 0
    for x in stack:
        sum += x
    print(sum)
else:
    print(0)