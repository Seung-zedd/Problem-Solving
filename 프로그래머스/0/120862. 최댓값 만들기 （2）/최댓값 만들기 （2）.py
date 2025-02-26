from itertools import combinations

def solution(numbers):
    return max(val[0] * val[1] for val in list(combinations(numbers, 2)))