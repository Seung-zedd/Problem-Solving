def solution(array):
    ans = ""
    count = 0

    for i in array:
        ans += str(i)
    for s in ans:
        if s == '7':
            count += 1
    return count