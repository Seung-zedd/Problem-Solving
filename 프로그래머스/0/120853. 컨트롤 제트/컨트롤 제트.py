def solution(s):
    str_ls = s.split()
    sum = 0
    prev = 0

    for s in str_ls:
        if s == 'Z':
            sum -= prev
        else:
            prev = int(s)
            sum += prev
    return sum