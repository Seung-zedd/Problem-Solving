def solution(a, b):
    # gcd(a, b)를 사용하여 먼저 최대공약수를 구함
    def gcd(n, d):
        if d == 0:
            return n
        return gcd(d, n % d)

    gcd_val = gcd(a, b)
    # 기약분수로 만듦
    b //= gcd_val
    
    # 분모가 1이면 항상 유한소수
    if b == 1:
        return 1
    
    # 분모의 소인수가 2와 5만 존재하는지 확인
    # 2로 나눌 수 있는 만큼 나눔
    while b % 2 == 0:
        b //= 2
    # 5로 나눌 수 있는 만큼 나눔
    while b % 5 == 0:
        b //= 5
    
    # 만약 b가 1이 되었다면, 소인수가 2와 5만 존재했다는 의미
    return 1 if b == 1 else 2