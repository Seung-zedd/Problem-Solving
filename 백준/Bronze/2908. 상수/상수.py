import sys
input = sys.stdin.readline

a, b = input().split()
a = list(a) # ['7', '3', '4']
b = list(b)
new_a = a[-1]+a[-2]+a[-3]
new_b = b[-1]+b[-2]+b[-3]
print(max(new_a, new_b))

    
