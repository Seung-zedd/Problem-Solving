import sys
T = int(input())

for i in range(T):
    input = sys.stdin.readline
    a, b = map(int, input().split())
    print(f"Case #{i+1}: {a+b}")