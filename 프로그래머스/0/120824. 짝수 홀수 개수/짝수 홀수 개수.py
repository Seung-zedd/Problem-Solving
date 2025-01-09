def solution(num_list):
    answer = []
    even = []
    odd = []

    for x in num_list:
        if x % 2 == 0:
            even.append(x)
        else:
            odd.append(x)
    answer.append(len(even))
    answer.append(len(odd))

    return answer