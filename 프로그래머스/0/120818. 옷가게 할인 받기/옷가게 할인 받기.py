def solution(price):
    if price < 100000:
        return price 
    elif 100000 <= price < 300000:
        return int(price * 0.95)
    elif 300000 <= price < 500000:
        return int(price * 0.9)
    else:
        return int(price * 0.8)