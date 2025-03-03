def solution(board):
    r = len(board)
    c = len(board[0])
    visited = [[False] * c for i in range(r)]
    
    def danger_search(start_x, start_y):
        visited[start_x][start_y] = True

        # 좌상부터 시계방향으로 세팅
        dr = [-1, -1, -1, 0, 1, 1, 1, 0]
        dc = [-1, 0, 1, 1, 1, 0, -1, -1]

        for i in range(8):
            next_x = start_x + dr[i]
            next_y = start_y + dc[i]

            # 범위 설정
            if 0 <= next_x <= r - 1 and 0 <= next_y <= c - 1:
                if visited[next_x][next_y] == False and board[next_x][next_y] == 0:
                    visited[next_x][next_y] = True
    # board 순회
    for i in range(r):
        for j in range(c):
            if board[i][j] == 1:
                danger_search(i,j)
    danger = sum(sum(row) for row in visited)
    return r*c - danger