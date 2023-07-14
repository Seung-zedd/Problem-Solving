import sys
input = sys.stdin.readline

T = int(input())

if (1 <= T <= 10):
    for i in range(1, T+1):
        str = input().upper().rstrip('\n')
        print(str[0], end="")
        print(str[-1])