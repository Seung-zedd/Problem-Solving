def solution(n):
    fact_dict = {1: 1, 2: 2, 6: 3, 24: 4, 120: 5, 720: 6, 5040: 7, 40320: 8, 362880: 9, 3628800: 10}
    max_val = 1

    for k, v in fact_dict.items():
        if k > n:
            return fact_dict[max_val]
        max_val = k  # 현재까지의 최댓값 갱신
    return fact_dict[max_val]  # 루프가 끝난 경우(k == n), max_val의 값을 반환