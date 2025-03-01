def solution(my_string):
    num = 0
    str_num = "" 

    for s in my_string:
        if s.isdigit():
            str_num += s
        elif s.isdigit() is False and len(str_num):
            num += int(str_num)
            str_num = ""
    if len(str_num): # 문자열에 숫자만 있는 경우
        num += int(str_num)
        return num
    return num # 문자열에 문자만 있는 경우 0으로 초기화했던 값을 리턴
