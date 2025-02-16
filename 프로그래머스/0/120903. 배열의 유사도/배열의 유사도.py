def solution(s1, s2):
    count = 0

    if len(s1) >= len(s2):
        for s in s1:
            for t in s2:
                if s == t:
                    count += 1
    else:
        for t in s2:
            for s in s1:
                if t == s:
                    count += 1
    return count