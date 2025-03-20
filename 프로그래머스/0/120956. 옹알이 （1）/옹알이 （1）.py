from itertools import permutations as perm

def solution(babbling):
    babbling_ls = ["aya", "ye", "woo", "ma"]
    word = 0
    # 임의로 조합한 발음을 사용하는 경우
    for k in range(len(babbling_ls) + 1):
        bab_perm = perm(babbling_ls, k)
        bab_perm = list(bab_perm)
        temp = ""
        for s in bab_perm:
            temp += "".join(s) + " "
        word_ls = temp.split()

        for s in babbling:
            for w in word_ls:
                if len(s) == len(w) and s == w:
                    word += 1
    return word