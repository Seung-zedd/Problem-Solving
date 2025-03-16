def solution(numlist, n):
    num_dist = [(i, abs(n - i)) for i in numlist]  # [num, length]

    # n과 가까운 거리를 기준으로 오름차순 정렬
    len_sorted_ls = sorted(num_dist, key=lambda num: num[1])
    # len_ls를 순회하는데 거리가 같으면 더 큰 수 앞에 배치
    for idx, (num, dist) in enumerate(len_sorted_ls):
        # list index out of range 문제 핸들링
        if idx == len(len_sorted_ls) - 1:
            break

        next_dist = len_sorted_ls[idx + 1][1]
        next_num = len_sorted_ls[idx + 1][0]
        # 거리가 같고 작은 수가 앞에 있으면 스왑
        # 거리가 같은데 이미 큰 수가 앞에 있으면 스왑 x
        if dist == next_dist and next_num > num:
            # 스왑(언패킹 활용)
            len_sorted_ls[idx], len_sorted_ls[idx + 1] = len_sorted_ls[idx + 1], len_sorted_ls[idx]
    return [num for num, len in len_sorted_ls]
