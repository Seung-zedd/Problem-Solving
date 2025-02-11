def solution(order):
    dict = {} # {num: clap}
    
    for s in str(order):
        if s == '3' or s == '6' or s == '9':
            dict[s] = dict.get(s, 0) + 1
        else:
            dict[s] = 0
    return sum(dict.values())