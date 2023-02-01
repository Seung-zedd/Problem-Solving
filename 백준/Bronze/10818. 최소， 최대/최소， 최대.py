import sys
input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))

# sort함수를 써서 오름차순으로 정렬 후 lst[0], lst[-1] 출력
lst.sort()
print(lst[0], lst[-1], sep=" ")