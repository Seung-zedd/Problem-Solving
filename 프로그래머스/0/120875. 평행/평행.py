from itertools import combinations

def solution(dots):
    # 가능한 모든 점 쌍(직선) 조합 구하기
    lines = list(combinations(range(4), 2))
    
    # 가능한 모든 직선 쌍 조합 구하기
    pairs = []
    for i in range(len(lines)):  # 0부터 5까지 (lines의 길이)
        for j in range(i + 1, len(lines)):  # i+1부터 5까지
            # 두 직선이 서로 다른 4개의 점으로 이루어져야 함
            if len(set(lines[i] + lines[j])) == 4:
                pairs.append((lines[i], lines[j]))
    
    # 각 직선 쌍에 대해 기울기를 계산하고 평행 여부 확인
    for (a, b), (c, d) in pairs:
        x1, y1 = dots[a]
        x2, y2 = dots[b]
        x3, y3 = dots[c]
        x4, y4 = dots[d]
        
        # 기울기 계산
        gradient1 = (y2 - y1) / (x2 - x1)
        gradient2 = (y4 - y3) / (x4 - x3)
        
        # 기울기가 같으면 평행 또는 일치
        if gradient1 == gradient2:
            return 1
    
    return 0