def solution(balls, share):
    # n! / (n-r)! * r!
    # sol1) solve the problem using recursive function
    def fact(x):
        # base condition
        if x <= 1:
            return 1
        return fact(x-1) * x
    return fact(balls) // (fact(balls - share) * fact(share))