def solution(quiz):
    # 배열의 원소들을 split()을 사용해서 전부 나눔
    quiz_ls = [q.split() for q in quiz]
    op = ""
    l_val = []
    r_val = []
    res = []  # 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열

    for r in quiz_ls:
        for s in r:
            # 등호를 만나면 우값을 int로 바꿈
            if s == "=":
                r_val.append(int(r[r.index(s) + 1]))
                break
            elif s == "+" or s == "-":
                op = s
            else:
                l_val.append(int(s))

            if len(l_val) == 2 and op == "+":
                temp = sum(l_val)
                l_val = []
                l_val.append(temp)
            elif len(l_val) == 2 and op == "-":
                temp = l_val[0] - l_val[1]
                l_val = []
                l_val.append(temp)
        # l_val과 r_val이 맞는지 검사
        if l_val[0] == r_val[0]:
            res.append("O")
        else:
            res.append("X")
        l_val = []
        r_val = []
    return res