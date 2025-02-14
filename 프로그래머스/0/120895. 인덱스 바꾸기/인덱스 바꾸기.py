def solution(my_string, num1, num2):
    temp = ""

    for idx, s in enumerate(my_string):
        if idx == num1:
            temp += my_string[num2]
        elif idx == num2:
            temp += my_string[num1]
        else:
            temp += s
    return temp