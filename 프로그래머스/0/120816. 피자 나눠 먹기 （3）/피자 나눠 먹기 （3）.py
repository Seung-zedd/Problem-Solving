def solution(slice, n):
    pizza = 0
    pizza = n // slice

    if n % slice != 0:
        pizza += 1
    return pizza