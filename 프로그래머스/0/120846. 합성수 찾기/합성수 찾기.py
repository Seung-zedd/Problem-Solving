def solution(n):
    # (n-1) - len(소수)인데, 1은 제외됬고, zero-based idx라 서로 상쇄되므로, 그냥 n - len(is_prime)
    is_prime = [True] * (n + 1) # 0 <= x <= N == (N+1) 개수
    is_prime[1] = False

    for i in range(2, int(n ** 0.5) + 1): # 1차 필터링
        if not is_prime[i]:
            continue
        for j in range(2 * i, n + 1, i): # 2차 필터링
            is_prime[j] = False
    return n - len([x for x in is_prime if x])
