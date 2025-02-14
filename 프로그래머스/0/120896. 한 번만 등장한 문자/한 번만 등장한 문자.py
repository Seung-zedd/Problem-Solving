def solution(s):
    dict = {} # {alpha: count}
    answer = []
    for x in s:
        dict[x] = dict.get(x, 0) + 1
    for alpha, val in dict.items():
        if val == 1:
            answer += alpha
    return "".join(sorted(answer))