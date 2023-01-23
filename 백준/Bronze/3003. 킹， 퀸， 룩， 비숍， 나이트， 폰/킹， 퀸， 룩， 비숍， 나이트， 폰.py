chess = [1,1,2,2,2,8] # 체스 피스

white = [] # 동혁이가 찾은 흰색 피스
a,b,c,d,e,f = map(int, input().split())
white.append(a)
white.append(b)
white.append(c)
white.append(d)
white.append(e)
white.append(f)

ziplist = list(zip(white, chess)) # 동일한 두 리스트의 요소를 각각 튜플로 묶어줌
for x, y in ziplist:
    if x < y:
        print(y - x, end=" ")
    elif x == y:
        print(0, end=" ")
    elif x > y:
        print(-(x-y), end=" ")        