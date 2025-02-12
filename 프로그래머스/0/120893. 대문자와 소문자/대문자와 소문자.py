def solution(my_string):
    ls = []

    for s in my_string:
        if s.islower():
            ls.append(s.translate({ord(s.lower()): s.upper()}))
        else:
            ls.append(s.translate({ord(s.upper()): s.lower()}))
    return "".join(ls)