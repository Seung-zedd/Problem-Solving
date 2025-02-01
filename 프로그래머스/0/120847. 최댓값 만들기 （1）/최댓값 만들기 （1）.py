def solution(numbers):
    ls = []

    numbers.sort()
    max_val = max(numbers)
    ls.append(max_val)
    numbers.pop()

    max_val_2 = max(numbers)
    ls.append(max_val_2)

    return ls[0] * ls[1]