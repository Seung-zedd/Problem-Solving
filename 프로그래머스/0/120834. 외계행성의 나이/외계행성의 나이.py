def solution(age):
    # int는 iterable하지 않기 때문에 str으로 감싼 다음 map()을 사용해서 리스트로 변환
    num_list = list(map(int, str(age)))
    
    # 아스키 코드값을 활용하여 숫자 -> 알파벳으로 변환
    ls = [chr(i + 97) for i in num_list]

    return ''.join(ls)