def solution(num_list, n):

    # 리스트 컴프리헨션을 사용해서 2차원 배열 생성
    mul = len(num_list) // n
    arr = [[False for col in range(n)] for row in range(mul)]

    # 만들어진 arr 1차원 배열에 num_list를 슬라이싱한 ls를 각각 얕은 복사
    for i in range(mul):
        # [0:3] ~ [3:6] ~[6:9] ~ ...
        ls = num_list[i * n : (i + 1) * n]
        arr[i] = ls
    return arr