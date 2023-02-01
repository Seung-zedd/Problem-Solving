import sys
input = sys.stdin.readline

S = input()

for i in range(97,123): # 소문자 = 대문자 + 32
    print(S.find(chr(i)), end=" ")   

