def solution(array):
    dict = {}

    for num in array:
        # Key가 없으면 0을 리턴
        # l-value는 value로 저장하기 위한 것이고, r-value는 리터럴 값임
        dict[num] = dict.get(num, 0) + 1 # r-value is 1 or num + 1
    max_count = max(dict.values())
    result = [k for k, v in dict.items() if v == max_count]

    if len(result) >= 2:
        return -1
    else:
        return result[0]