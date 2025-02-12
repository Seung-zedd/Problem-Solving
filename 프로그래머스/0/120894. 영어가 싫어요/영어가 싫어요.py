def solution(numbers):
    # 문자열을 숫자에 매핑
    dict = {"one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6, "seven": 7, "eight": 8, "nine": 9, "zero": 0}
    temp = "" # 문자열을 자르기 위함
    res = [] # int형 값을 저장하기 위함

    for s in numbers:
        temp += s
        if temp in dict:
            res.append(str(dict[temp]))
            temp = "" # 숫자를 저장했으면 문자열을 비운다
    return int("".join(res))