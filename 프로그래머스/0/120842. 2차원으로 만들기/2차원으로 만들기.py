def solution(num_list, n):
    mul = len(num_list) // n
    answer = []
    
    answer = [num_list[i * n : (i + 1) * n] for i in range(mul)]
    return answer