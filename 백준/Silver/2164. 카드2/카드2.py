
from collections import deque

d = deque()
ls = []
N = int(input()) # 테스트 케이스 개수
# N장의 카드만큼 카드를 추가
for x in range(1, N+1):
    d.append(x)

for _ in range(N-1):
    d.popleft() # 위의 카드를 버림
    ls.append(d[0]) # 프론트를 빈 리스트에 저장
    d.popleft() # 복사당한 원소를 제거
    d.append(ls[-1]) # 저장한 원소를 덱에 추가
print(*d)