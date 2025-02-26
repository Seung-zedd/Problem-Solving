def solution(keyinput, board):
    answer = [0, 0] # 캐릭터는 항상 [0,0]에서 시작
    dx = answer[0]
    dy = answer[1]
    range_x = board[0] // 2
    range_y = board[1] // 2

    dict = {"left": -1, "right": +1, "up": +1, "down": -1}

    for s in keyinput:
        # 전체 범위 설정
        if -range_x <= dx <= range_x and -range_y <= dy <= range_y:
            # 다음 이동할 좌표의 범위를 검사
            if (s == "left" and dx - 1 >= -range_x) or (s == "right" and dx + 1 <= range_x):
                dx += dict[s] # 좌표 업데이트
            elif (s == "down" and dy - 1 >= -range_y) or (s == "up" and dy + 1 <= range_y):
                dy += dict[s]
        # 크기를 벗어났으므로 입력값 무시
        else:
            continue
    return [dx, dy]