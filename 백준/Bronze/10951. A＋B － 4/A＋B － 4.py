import sys
input = sys.stdin.readline

while(True): # 무한루프
    try:
        a, b = map(int, input().split())
        print(a+b)
    except:
        break
    

