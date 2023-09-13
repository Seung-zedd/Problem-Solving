import sys

input = sys.stdin.readline

str = input()
new_str = sorted(str)
print(''.join(new_str[::-1]))