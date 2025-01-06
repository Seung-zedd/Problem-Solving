def solution(money):
    answer = []
    max_americano = money // 5500
    change = money % 5500
    answer.append(max_americano)
    answer.append(change)

    return answer