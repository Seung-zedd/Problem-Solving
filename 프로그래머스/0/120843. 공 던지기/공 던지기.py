def solution(numbers, k):
    # numbers에 있는 원소들을 앞에는 홀수, 뒤에는 짝수 원소로 재구성
    odd_numbers = [x for x in numbers if x % 2 != 0]
    rearrange_numbers = [x for x in numbers if x % 2 != 0] + [x for x in numbers if x % 2 == 0]

    if len(numbers) % 2 == 0:
        return odd_numbers[(k - 1) % (len(numbers) // 2)]
    else:
        return rearrange_numbers[(k - 1) % len(rearrange_numbers)]