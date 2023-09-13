import sys
input = sys.stdin.readline

N, k = map(int, input().split()) # 테스트 케이스 개수

a = list(map(int, input().split()))
a.sort()

for x in range(k):
    num = a.pop()
print(num)