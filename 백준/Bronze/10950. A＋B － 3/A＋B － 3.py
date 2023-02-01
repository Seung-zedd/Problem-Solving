num = int(input())
lst = []
for i in range(0, num):
    a, b = map(int, input().split())
    result = a + b
    lst.append(result)

for i in lst:
    print(i)




