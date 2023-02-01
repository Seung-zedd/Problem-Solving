import sys
input = sys.stdin.readline
lst = []
for i in range(28):
    lst.append(int(input())) # 서로 다른 28개의 자연수 입력

check_list = range(1,31) # 1 ~ 30까지 숫자 체크

for i in check_list:
    if i not in lst:
        print(i)
        
   