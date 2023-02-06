import sys
input = sys.stdin.readline

T = int(input()) # 개수 입력

for i in range(T):
    a, b = map(int, input().split(',')) # 아무것도 입력을 안했을 때는 공백을 기준으로 입력
    print(a+b)


