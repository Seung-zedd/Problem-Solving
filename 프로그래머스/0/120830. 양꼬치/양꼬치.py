def solution(n, k):
    sheep = n * 12000
    drink = k * 2000
    free_drink = (n // 10) * 2000

    return sheep + drink - free_drink