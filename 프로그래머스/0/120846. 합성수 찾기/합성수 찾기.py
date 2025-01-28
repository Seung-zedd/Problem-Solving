def solution(n):
    not_composite = [1]
    is_prime = {} # {num: count}
    for x in range(1, n + 1):
        for y in range(2, x + 1):
            if x % y == 0:
                is_prime[x] = is_prime.get(x, 0) + 1
        if is_prime.get(x) == 1:
            not_composite.append(x)
    return n - len(not_composite)