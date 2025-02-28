def solution(polynomial):
    # 더하기를 기준으로 파싱
    ls = polynomial.split(" + ")

    # 일차항과 상수항으로 분류
    coeff = 0
    const = 0

    for s in ls:
        if 'x' not in s:
            const += int(s)
        elif s == 'x':
            coeff += 1
        else:
            coeff += int(s[:-1])
    # 일차항 + 상수항, 일차항, 상수항으로 분류해서 리턴
    if coeff and const:
        term = 'x' if coeff == 1 else str(coeff) + 'x'
        return term + ' + ' + str(const)
    elif const == 0:
        return "x" if coeff == 1 else str(coeff) + "x"
    elif coeff == 0:
        return str(const)