import sys
input = sys.stdin.readline
# N개 중 자기 점수의 최댓값을 고름 => M
# 모든 점수: 점수/M*100
# 새로운 방법으로 계산한 점수의 평균을 출력
N = int(input())

score_list= list(map(int, input().split()))
M = max(score_list)
new_list = []
for i in score_list:
    i = i/M*100
    new_list.append(i)
print(float(sum(new_list) / len(new_list)))

    

