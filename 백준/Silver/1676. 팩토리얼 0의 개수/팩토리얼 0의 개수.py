import sys
input = sys.stdin.readline

# 0이 아닌 숫자가 나오면 멈춤
n = int(input())

zero = []
result = 1
for i in range(1, n+1):
    result *= i

result = str(result)

for char in result[::-1]:
    if(char == '0'):
        zero.append(char)
    else:
        break
print(int(zero.count('0')))