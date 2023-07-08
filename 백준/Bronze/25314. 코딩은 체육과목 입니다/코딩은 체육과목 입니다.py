import sys
input = sys.stdin.readline

N = int(input())

if (N % 4 == 0): # N이 4의 배수이면
    N = N // 4 # long을 4로 나눈 값으로 출력하기 위함
    for i in range(1,(N+1)):
        print("long", end=" ")
print("int")    