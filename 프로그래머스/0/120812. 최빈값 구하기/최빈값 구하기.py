def solution(array):
    memo = {}

    # array에 있는 원소들을 순회하면서 카운팅을 함
    # num이 없으면 애초에 카운팅이 x
    for num in array:
        memo[num] = memo.get(num, 0) + 1

    # 최빈값의 빈도 계산
    max_count = max(memo.values())
    result = [key for key, value in memo.items() if value == max_count]

    # 최빈값이 2개 이상이면 -1을 리턴
    if len(result) >= 2:
        return -1
    # 그렇지 않으면 mode를 리턴
    else:
        return result[0]