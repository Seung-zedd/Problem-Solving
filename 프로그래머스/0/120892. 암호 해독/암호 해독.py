def solution(cipher, code):
    return "".join([cipher[s] for s in range(code - 1, len(cipher), code)])