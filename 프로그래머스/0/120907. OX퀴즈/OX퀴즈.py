def solution(quiz):
    ans = []
    # 배열의 원소들을 split(' = ')을 사용해서 좌값과 우값을 먼저 나눔
    for q in quiz:
        l_val, r_val = q.split(' = ')
        a, op, b = l_val.split()
        r_val = int(r_val)

        if op == '+':
            l_val = int(a) + int(b)
        else:
            l_val = int(a) - int(b)
        ans.append("O" if l_val == r_val else "X")
    return ans