# 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있음
# M: 바꾸려는 횟수
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

ls = [i for i in range(1, N+1)] # 1 ~ N

if (1 <= N <= 100 and 1 <= M <= 100):
    for a in range(1,M+1):
        i, j = map(int, input().split())
        if(1 <= i <= N and 1 <= j <= N ):
            ls[j-1], ls[i-1] = ls[i-1], ls[j-1]

for b in range(0, N):
    print(ls[b], end=" ")