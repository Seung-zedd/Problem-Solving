def solution(n):
    def gcd(p, q):
        if q == 0:
            return p
        return gcd(q, p % q)
    return n // gcd(n, 6)