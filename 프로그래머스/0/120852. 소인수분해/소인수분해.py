def solution(n):
    d = 2
    ans = []

    while d <= n:
        if n % d == 0:
            ans.append(d)
            n //= d
        else:
            d += 1
    return sorted(set(ans))