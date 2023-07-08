import sys
input = sys.stdin.readline

S = input()
i = int(input())

if (1 <= i and i <= len(S)):
    print(S[i-1])