def solution(s):
    str_ls = s.split()
    stack = []

    for s in str_ls:
        if s == 'Z':
            stack.pop()
        else:
            stack.append(int(s))
    return sum(stack)