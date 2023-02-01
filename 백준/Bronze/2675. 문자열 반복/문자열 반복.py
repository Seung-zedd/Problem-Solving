import sys
input = sys.stdin.readline
# QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:
N = int(input())

for i in range(N):
    num, alpha = (input().split())
    lst = (list(alpha)) # lst = [['A', 'B', 'C'], ['/', 'H', 'T', 'P']]
    for i in lst:
        for j in i:
            print(j * int(num), end="")
    print()
       
    

