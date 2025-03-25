def solution(i, j, k):
    my_dict = {} # {int: str}
    count = 0
    for i in range(i, j + 1):
        my_dict[i] = str(i)
    for v in my_dict.values():
        for s in v:
            if str(k) in s:
                count += 1
    return count