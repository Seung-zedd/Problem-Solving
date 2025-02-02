def solution(n):
    # set {fact_val: num}
    dict = {1: 1, 2: 2, 6: 3, 24: 4, 120: 5, 720: 6, 5040: 7, 40320: 8, 362880: 9, 3628800: 10}
    max_val = 1

    # dict의 value를 리턴
    for k in dict.keys():
        # max값을 n보다 작을 때까지 계속 업데이트
        if k < n:
            max_val = k
        elif k == n:
            max_val = k
            return dict[max_val]
        else:
            return dict[max_val]