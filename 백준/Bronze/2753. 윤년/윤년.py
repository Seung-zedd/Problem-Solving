# 윤년 : 연도가 4의 배수이면서, 100의 배수가 아닐 때 "또는" 400의 배수일 때
year = int(input())

A = year % 4 == 0 # 1999 % 4 = 3 -> True / 반환값을 1 또는 0 으로 해야됨
B = year % 100 != 0
C = year % 400 == 0
yoon = A and B or C

if yoon == True:
    print(1)
else:
    print(0)