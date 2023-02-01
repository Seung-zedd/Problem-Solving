import sys
num = int(input())

for i in range(num):
    input = sys.stdin.readline
    a, b = map(int, input().split())
    print(a+b)