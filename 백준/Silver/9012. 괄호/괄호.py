import sys
input = sys.stdin.readline

N = int(input()) # 테스트 케이스 개수

def isValid(s):
    stack = []
    for x in s:
        if x == '(':
            stack.append(')')
        
        elif not stack or stack.pop() != x:
                print("NO")
                return False
    if stack:
        print("NO")
        return False
    else:
        print("YES")
        return True

for _ in range(N):
    s = input().rstrip('\n')
    isValid(s)