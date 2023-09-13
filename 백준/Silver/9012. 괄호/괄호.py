import sys
input = sys.stdin.readline

'''
만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다. 
'''

N = int(input()) # 테스트 케이스 개수
stack = []

def isValid(s):
    for x in s:
        if x == '(':
            stack.append(')')
        else:
            while not stack or stack.pop() != x:
                print("NO")
                stack.clear()
                return False
    if stack:
        print("NO")
        stack.clear()
        return False
    else:
        print("YES")
        stack.clear()
        return True
    
for _ in range(N):
    s = input().rstrip('\n')
    isValid(s)
    