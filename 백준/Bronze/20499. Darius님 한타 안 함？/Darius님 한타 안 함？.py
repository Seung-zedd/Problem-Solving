import sys
input = sys.stdin.readline

str = input().rstrip('\n')
str_ls = str.split('/')

int_ls = list(map(int, str_ls))
K = int_ls[0]
D = int_ls[1]
A = int_ls[2]

if (0 <= K <= 20 and 0 <= D <= 20 and 0 <= A <= 20):
    if (K + A < D or D == 0):
        print("hasu")
    else:
        print("gosu")