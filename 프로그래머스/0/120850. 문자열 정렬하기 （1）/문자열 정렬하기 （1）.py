import re

def solution(my_string):
    ls_str = re.findall('[0-9]', my_string)

    # ls 안의 str 원소를 int로 변환
    ls_int = list(map(int, ls_str))
    return sorted(ls_int)