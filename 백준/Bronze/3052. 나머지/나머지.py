import sys
input = sys.stdin.readline
lst = set()

for i in range(10):
    lst.add(int(input()) % 42) # update:요소 여러개 추가, 만약 update함수를 쓰고 싶다면 [] 또는 {}로 1개 이상의 인자값을 넣어야함
print(len(lst))
    
    

