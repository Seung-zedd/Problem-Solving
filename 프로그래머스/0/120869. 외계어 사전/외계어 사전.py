def solution(spell, dic):
    sorted_spell = sorted(spell)

    for word in dic:
        if sorted_spell == sorted(word):
            return 1
    return 2