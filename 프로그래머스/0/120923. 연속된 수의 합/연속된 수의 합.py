def solution(num, total):
    ls = []
    a = (total / num) + (1 - num) / 2
    for i in range(num):
        ls.append(int(a))
        a += 1
    return ls