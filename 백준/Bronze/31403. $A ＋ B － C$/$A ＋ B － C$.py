import sys
# sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

data = []  # 각 줄의 데이터를 저장할 리스트

for _ in range(3):
    num = int(input())  # 각 줄의 숫자를 읽음
    data.append(num)  # 읽은 숫자를 data 리스트에 추가
print(data[0] + data[1] - data[2])
temp = str(data[0]) + str(data[1])
print(int(temp) - data[2])