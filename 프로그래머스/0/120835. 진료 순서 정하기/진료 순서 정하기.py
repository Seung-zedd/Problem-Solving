def solution(emergency):
    # 1. 응급도가 높은 순서대로 먼저 정렬
    emergency_sorted = sorted(emergency, reverse=True)
    # 2. 그것을 기준으로 진료 순서를 매김
    emergency_rank = {}
    for i in emergency_sorted:
        emergency_rank[i] = emergency_sorted.index(i) + 1
    # 3. 진료 순서를 정한 배열을 리턴
    return [emergency_rank[num] for num in emergency]