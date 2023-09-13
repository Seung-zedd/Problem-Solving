import sys

input = sys.stdin.readline

stack = []
# 1~5번 함수 구현

def push():
    stack.append(num[1])


def pop_top():
    if stack:
        print(stack.pop())
    else:
        print(-1)


def count():
    print(len(stack))

def isEmpty():
    if not stack:
        print(1)
    else:
        print(0)


def print_top():
    if stack:
        print(stack[-1])
    else:
        print(-1)


N = int(input())  # 테스트 케이스 개수

for _ in range(N):
    num = list(map(int, input().split()))

    if num[0] == 1 and num[1]:
        push()

    elif num[0] == 2:
        pop_top()

    elif num[0] == 3:
        count()

    elif num[0] == 4:
        isEmpty()

    elif num[0] == 5:
        print_top()
