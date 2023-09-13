import sys
input = sys.stdin.readline

ls = []

for x in range(5):
    x = int(input())
    ls.append(x)
ls.sort()

sum = 0
for x in ls:
    sum += x
avg = sum // 5
print(avg)
print(ls[2])