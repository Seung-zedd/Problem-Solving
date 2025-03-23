def solution(bin1, bin2):
    num1 = 0
    num2 = 0
    for idx, s in enumerate(bin1):
        num1 += pow(2, len(bin1) - idx - 1) * int(s)
    for idx, s in enumerate(bin2):
        num2 += pow(2, len(bin2) - idx - 1) * int(s)

    temp = num1 + num2
    mod = ""
    while 2 <= temp:
        mod += str(temp % 2)
        temp //= 2

    result = mod + str(temp)
    return result[::-1]