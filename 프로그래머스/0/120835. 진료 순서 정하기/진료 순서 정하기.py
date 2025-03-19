def solution(emergency):
    # 1. 응급도가 높은 순서로 내림차순 정렬한다
    emergency_sorted = sorted(emergency, reverse=True)
    # 2. 정렬한 리스트에 대해 진료 순서를 index + 1로 정한다
    emergency_rank = {} # {emergency: index + 1}
    for idx, score in enumerate(emergency_sorted):
        emergency_rank[score] = idx + 1
    # 3. 딕셔너리를 이용해서 value를 불러옴
    return [emergency_rank[score] for score in emergency]