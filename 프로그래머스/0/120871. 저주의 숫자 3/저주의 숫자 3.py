def solution(n):
    dict_3x = {1: 1, 2: 2}

    for i in range(3, n + 1):
        dict_3x[i] = dict_3x[i - 1] + 1

        while dict_3x[i] % 3 == 0 or "3" in str(dict_3x[i]):
            dict_3x[i] += 1
    return dict_3x[n]