def solution(emergency):
    # 내림차순으로 먼저 정렬 후, <K=value, V=idx + 1>로 딕셔너리 초기화
    rank = {value: idx + 1 for idx, value in enumerate(sorted(emergency, reverse=True))}
    # 배열 순회하면서 rank[value]로 리스트 컴프리헨션 사용
    return [rank[x] for x in emergency]
    # T.C: O(NlogN), using quick sort