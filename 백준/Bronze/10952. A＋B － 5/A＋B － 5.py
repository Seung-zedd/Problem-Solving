import sys
input = sys.stdin.readline

while(True): # 무한루프
    a, b = map(int, input().split())
    if a == 0 and b == 0:
        break
    else:
        print(a+b)

