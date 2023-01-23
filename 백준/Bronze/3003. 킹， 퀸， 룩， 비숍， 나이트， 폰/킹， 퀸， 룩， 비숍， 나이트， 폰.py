chess = [1,1,2,2,2,8] # 체스 피스

white = list(map(int, input().split())) # 동혁이가 찾은 흰색 피스

for i in range(len(chess)):
    white[i] = chess[i] - white[i]

print(*white)