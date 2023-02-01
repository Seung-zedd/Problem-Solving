# each price, count, sum(price)
# price * count == sum(price)?

sum = int(input())
count = int(input())
result = 0
for i in range(count):
    a, b = map(int, input().split())
    result +=  a * b

if sum == result:
    print("Yes")
else:
    print("No")