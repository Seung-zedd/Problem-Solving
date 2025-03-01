def solution(polynomial):
    ls = polynomial.split(" + ")
    # 계수 분리를 위함
    coeff = 0
    const = 0

    # 분류 작업
    for term in ls:
        if term == 'x':
            coeff += 1
        elif 'x' in term:
            coeff += int(term[:-1])
        else:
            const += int(term)
    # 리턴 작업: 일차항 + 상수항, 일차항, 상수항
    term = 'x' if coeff == 1 else str(coeff) + 'x'
    if coeff and const:
        return term + ' + ' + str(const)
    elif const == 0:
        return term
    elif coeff == 0:
        return str(const)