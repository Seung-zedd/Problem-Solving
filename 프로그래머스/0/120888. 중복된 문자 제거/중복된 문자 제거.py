def solution(my_string):
    dict = {}

    for s in my_string:
        if s in dict:
            continue
        else: 
            dict[s] = dict.get(s, 0) + 1
    return "".join(dict.keys())