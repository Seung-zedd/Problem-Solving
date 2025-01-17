def solution(hp):
    general_ant = hp // 5  # 장군개미 먼저 사용
    remainder = hp % 5

    soldier_ant = remainder // 3
    work_ant = remainder % 3

    return general_ant + soldier_ant + work_ant