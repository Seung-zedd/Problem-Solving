def solution(n):
    is_prime = [True] * (n + 1)
    is_prime[1] = False # 1은 제외

    for i in range(2, int(n ** 0.5) + 1):
        if not is_prime[i]: continue
        for j in range(2 * i, n + 1, i):
            is_prime[j] = False
    prime_ls = [x for x in is_prime[2:] if x]

    return (n - 1) - len(prime_ls)