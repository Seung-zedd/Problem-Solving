def solution(numbers, k):
    # len(numbers) = len((numbers % 2 == 0)) + len(numbers % 2 != 0)
    return numbers[2 * (k - 1) % len(numbers)]