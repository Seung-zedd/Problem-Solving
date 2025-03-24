def solution(before, after):
    before_dict = {}  # {before: letter counting}
    after_dict = {}
    for s in before:
        before_dict[s] = before_dict.get(s, 0) + 1
    for s in after:
        after_dict[s] = after_dict.get(s, 0) + 1

    # 두 딕셔너리가 완전히 동일한지 비교
    return 1 if before_dict == after_dict else 0