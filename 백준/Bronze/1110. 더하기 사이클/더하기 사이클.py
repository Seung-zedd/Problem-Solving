num = int(input()) # 주어진 수
temp = num
cnt = 0
while 0<= num <= 99:
    if num < 10:
        # 5 : 05, 0+5 = 5 55
        num = num * 10 + num
        cnt += 1
    else: # 55의 경우
        a = num // 10 # 5
        b = num % 10 # 5
        num = b*10 + (a+b) % 10 # 50
        cnt += 1
    if(temp == num):
        break
    
print(cnt)

