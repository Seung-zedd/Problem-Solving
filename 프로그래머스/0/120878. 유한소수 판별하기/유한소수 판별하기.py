def solution(a, b):
    def gcd(n, d):
        if d == 0:
            return n
        return gcd(d, n % d)
    gcd_val = gcd(a, b)
    # 분수를 소수로 나타냄(float)
    denom_factor = b // gcd_val

    # a == b => gcd_val == b
    # b == 1 => a/b는 항상 정수
    if b == gcd_val or b == 1:
        return 1
    # 분모의 소인수가 2와 5만 존재하는지가 관건
    while denom_factor % 2 == 0:
        denom_factor //= 2
    while denom_factor % 5 == 0:
        denom_factor //= 5
    return 1 if denom_factor == 1 else 2