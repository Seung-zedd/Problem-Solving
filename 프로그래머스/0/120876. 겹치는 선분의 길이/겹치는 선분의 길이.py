def solution(lines):
    def find_overlapped_line():
        # (교정) 지역변수로 수정
        line = [(0, 1), (0, 2), (1, 2)]
        overlapped_line = []
        for u, v in line:
            a, b = lines[u]
            c, d = lines[v]
            # end 부분은 포함 x(길이는 end - start이기 때문)
            # (교정) 리스트끼리 &연산은 안되서 리스트 컴프리헨션 부분에서 set()으로 각각 설정해줘야함
            line_a = set([i for i in range(a, b)])
            line_b = set([i for i in range(c, d)])

            overlapped_line.append(line_a & line_b)
        return overlapped_line

    intersect_set = find_overlapped_line()
    union_set = set()

    for s in intersect_set:
        # 겹치는 부분이 있으면
        if intersect_set:
            union_set |= s
        else:
            return 0
    return len(union_set)