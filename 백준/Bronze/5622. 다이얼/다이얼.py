import sys
input = sys.stdin.readline

S = input().upper().rstrip('\n')
my_dic = {"ABC": 3, "DEF": 4, "GHI": 5, "JKL": 6, "MNO": 7, "PQRS": 8, "TUV": 9, "WXYZ": 10}
# UNUCIC = 9+7+9+3+5+3=36
# WA = 10+3 = 13
sum = 0
#? 문자열을 딕셔너리와 어떻게 비교해서 value를 뱉어냄?
if (2 <= len(S) <= 15):
    for i in range(0, len(S)): # S의 문자열 순회
        for j in my_dic.keys(): # my_dic의 key 순회
            if S[i] in j: # key에 S[i]가 있으면
                sum += my_dic[j]
    print(sum)