def solution(array):
    array.sort()
    find_ix = len(array) // 2
    answer = array[find_ix]
    return answer