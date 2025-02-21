def solution(dots):
    ls = []

    for i in dots:
        if ls and ls[1] == i[1]:
            w = abs(ls[0] - i[0])
        elif ls and ls[0] == i[0]:
            h = abs(ls[1] - i[1])
        if len(ls) < 2:
            ls.append(i[0])
            ls.append(i[1])
    return w * h