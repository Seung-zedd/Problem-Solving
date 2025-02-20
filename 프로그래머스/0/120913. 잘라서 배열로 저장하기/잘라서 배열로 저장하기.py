def solution(my_str, n):
    return [my_str[s : s + n] for s in range(0, len(my_str), n)]