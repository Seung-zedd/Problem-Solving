def solution(array):
    dict = {}

    for num in array:
        dict[num] = dict.get(num, 0) + 1 # r-value is 1 or num + 1
    max_count = max(dict.values())
    result = [k for k, v in dict.items() if v == max_count]

    return -1 if len(result) >= 2 else result[0]