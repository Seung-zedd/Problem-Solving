def solution(my_string):
    num = 0
    str_num = "" 

    for s in my_string:
        if s.isdigit():
            str_num += s
        elif s.isdigit() is False and len(str_num):
            num += int(str_num)
            str_num = ""
    if len(str_num):
        num += int(str_num)
        return num
    return num