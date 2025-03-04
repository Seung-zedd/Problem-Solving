def solution(sides):
    x = 0
    y = 0
    
    # 1. 가장 긴 변이 sides 중에 한 원소일 경우
    x = max(sides) - abs(sides[0] - sides[1])
    # 2. 가장 긴 변이 sides 원소에 없을 경우
    y  = sum(sides) - max(sides) - 1
    return x + y