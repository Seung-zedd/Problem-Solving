import sys

input = sys.stdin.readline
N, X = map(int,input().split())
# 수열 A 중 X보다 작은 수를 하나씩 출력
lst = list(map(int, input().split()))

for i in lst:
    if i < X:
        print(min(i,X))
    else:
        pass