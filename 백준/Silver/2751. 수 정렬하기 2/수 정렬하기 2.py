import sys
input = sys.stdin.readline

N = int(input()) # 테스트 케이스 개수

ls = [int(input()) for x in range(N)]
ls.sort()
for x in ls:
    print(x)