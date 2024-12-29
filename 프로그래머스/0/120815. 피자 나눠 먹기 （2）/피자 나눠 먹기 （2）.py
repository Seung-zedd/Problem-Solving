def solution(n):
    def gcd(p, q):
        # modulo 연산 특징 때문에 굳이 case 분류해서 swap해주지 않아도됨
        if q == 0:
            return p
        return gcd(q, p % q)
    return n // gcd(n, 6)
