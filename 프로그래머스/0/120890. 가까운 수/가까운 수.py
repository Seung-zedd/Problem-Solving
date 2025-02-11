def solution(array, n):
    dict = {} # {length: num}
    array.sort()

    for x in array:
        if abs(x - n) in dict:
            continue
        else:
            dict[abs(x - n)] = x
    # key 최소값의 value를 리턴
    return dict[min(dict.keys())]