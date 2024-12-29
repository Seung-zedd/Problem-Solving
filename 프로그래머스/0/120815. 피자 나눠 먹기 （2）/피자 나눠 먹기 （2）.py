def solution(n):
    def gcd(p, q):
        # 1 <= n <= 6
        if p <= 6:
            q, p = p, q
            if p == 0:
                return q
            return gcd(p, q % p)
        else:
            # base condition
            if q == 0:
                return p
            return gcd(q, p % q)
    return n // gcd(n, 6)