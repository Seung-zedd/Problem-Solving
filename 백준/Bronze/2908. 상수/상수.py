import sys
input = sys.stdin.readline

a, b = input().split()
a = list(a)
b = list(b)
a.reverse(), b.reverse() # 리스트를 역순으로
new_a = ''.join(a) # join:역순의 리스트를 문자열로 합침
new_b = ''.join(b)
print(max(new_a,new_b))
    
