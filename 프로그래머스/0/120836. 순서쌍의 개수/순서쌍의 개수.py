def solution(n):
    divisor_count = 0
    # 양의 약수의 개수
    for i in range(1, n + 1):
        if n % i == 0: # 나누어 떨어지면
            divisor_count += 1
    return divisor_count