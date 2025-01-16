def solution(emergency):
    result = [len(emergency)] * len(emergency)

    for i in range(len(emergency)):
        for j in range(i + 1, len(emergency)):
            if emergency[i] < emergency[j]:
                result[j] -= 1
            else:
                result[i] -= 1
    return result