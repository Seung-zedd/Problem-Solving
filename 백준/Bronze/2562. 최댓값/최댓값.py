import sys
input = sys.stdin.readline
lst = []
for i in range(9):
    lst.append(int(input())) # 서로 다른 9개의 자연수 입력
print(max(lst))
print(lst.index(max(lst)) + 1)

