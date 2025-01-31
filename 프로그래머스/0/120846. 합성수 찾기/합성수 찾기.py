def solution(n):
    is_prime = [True] * (n + 1) # 배열은 0부터 시작하므로 1~N
    is_prime[1] = False # 1은 제외

    for i in range(2, int(n ** 0.5) + 1): # 약수의 순서쌍 특징 때문에 제곱근까지만
        if not is_prime[i]: continue # 이미 제거했으므로 아래 루프 무시
        for j in range(2 * i, n + 1, i): # 구구단 성질을 이용해 i의 배수 검사
            is_prime[j] = False # 1과 자기 자신 이외의 약수가 있으므로 제거
    prime_ls = [x for x in is_prime[2:] if x] # 2부터 시작한 에라토스테네스 체에 남겨진 소수들을 리스트 따로 저장

    return (n - 1) - len(prime_ls) # 합성수를 리턴하기 위해 n에서 1과 소수들을 뺀다
