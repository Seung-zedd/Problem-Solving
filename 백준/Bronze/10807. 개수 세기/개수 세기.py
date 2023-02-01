import sys
# N 만큼 입력을 받아 리스트에 추가
# 셋째 줄에 입력된 v를 count
# -100<=N,v<=100
input = sys.stdin.readline
N = int(input())
if -100<=N<=100:
    lst = list(map(int, input().split()))
    v = int(input())
    if -100<=v<=100:
        print(lst.count(v))
    
    



