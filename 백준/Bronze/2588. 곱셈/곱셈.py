num1 = int(input())
num2 = list(input()) # ['3,'8','5']
# num2 = (int(num2[0]) * 100 + int(num2[1]) * 10 + int(num2[2]))
num3 = num1 * int(num2[2])
num4 = num1 * (int(num2[1]) * 10)
num5 = num1 * (int(num2[0]) * 100)
num6 = num3 + num4 + num5

print(num3)
print(num4 // 10)
print(num5 // 100)   
print(num6)