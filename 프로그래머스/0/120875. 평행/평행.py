def solution(dots):
    # 4개의 점으로 만들 수 있는 서로 다른 두 직선의 모든 가능한 조합
    # 각 쌍은 ((첫번째 직선의 두 점 인덱스), (두번째 직선의 두 점 인덱스))를 나타냄
    line_pairs = [
        ((0, 1), (2, 3)),  # (dots[0], dots[1])와 (dots[2], dots[3])
        ((0, 2), (1, 3)),  # (dots[0], dots[2])와 (dots[1], dots[3])
        ((0, 3), (1, 2)),  # (dots[0], dots[3])와 (dots[1], dots[2])
    ]

    for (a, b), (c, d) in line_pairs:
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