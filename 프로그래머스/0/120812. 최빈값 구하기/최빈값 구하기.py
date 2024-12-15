def solution(array):
    memo = {}

    # array에 있는 원소들을 순회하면서 카운팅을 함
    # num이 없으면 애초에 카운팅이 x
    for num in array:
        memo[num] = memo.get(num, 0) + 1

    # 최빈값의 빈도 계산
    # items를 순회하는데, value가 내가 찾는 max_count와 일치하면 key를 result 리스트에 append
    max_count = max(memo.values())

    result_count = 0
    mode = -1

    for k, v in memo.items():
        if v == max_count:
            result_count += 1
            mode = k
    # corrected using ternary operator
    return -1 if result_count > 1 else mode