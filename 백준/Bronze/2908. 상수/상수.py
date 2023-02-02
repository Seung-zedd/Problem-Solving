import sys
input = sys.stdin.readline

a, b = input().split()
new_a = a[::-1]
new_b = b[::-1]
print(max(new_a,new_b))
    
