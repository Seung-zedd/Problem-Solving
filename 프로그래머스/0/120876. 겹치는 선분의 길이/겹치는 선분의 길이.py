def solution(lines):
    def find_overlapped_lines():
        line = [(0, 1), (0, 2), (1, 2)]
        overlapped_line = []
        # 임의의 2개 선분을 먼저 추출
        for u, v in line:
            a, b = lines[u]
            c, d = lines[v]

            # 직선을 set으로 표현 (종료점을 포함하지 않도록 수정)
            line_a = set(i for i in range(a, b))
            line_b = set(j for j in range(c, d))

            # 겹치는 부분 저장
            intersection = line_a & line_b
            if intersection:
                overlapped_line.append(intersection)

        return overlapped_line

    intersect_set = find_overlapped_lines()

    # 겹치는 부분이 있을 경우 합집합 계산
    if intersect_set:
        union_set = set()
        for s in intersect_set:
            union_set |= s
        return len(union_set)
    else:
        return 0
