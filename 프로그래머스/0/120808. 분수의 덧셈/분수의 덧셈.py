def solution(numer1, denom1, numer2, denom2):
    answer = []
    
    # 두 분수를 더한다
    r1 = (numer1 * denom2) + (numer2 * denom1) # 분자
    r2 = denom1 * denom2                       # 분모
    
    def gcd(a, b):
        if (b == 0): return a
        return gcd(b, a % b)
    
    gcd_result = gcd(r1, r2)
     
    answer.append(r1 / gcd_result)
    answer.append(r2 / gcd_result)
    
    return answer