from itertools import permutations
def solution(spell, dic):
    spell_permutation = permutations(spell)
    temp = ""

    for s in spell_permutation:
        for u in s:
            temp += u
        for d in dic:
            # 일단 길이가 먼저 맞아야됨
            if len(spell) == len(d) and d == temp:
                return 1
        temp = ""
    return 2