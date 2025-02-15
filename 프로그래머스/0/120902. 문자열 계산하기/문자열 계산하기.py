def solution(my_string):
    ls = my_string.split()
    op = "" # to store state
    res = [] # to store temporary result
    
    for s in ls:
        if s == '+' or s == '-':
            op = s
        else: res.append(int(s))
        if len(res) == 2 and op == '+':
            temp = sum(res)
            res = []
            res.append(temp)
        elif len(res) == 2 and op == '-':
            temp = res[0] - res[1]
            res = []
            res.append(temp)
    return res[0]