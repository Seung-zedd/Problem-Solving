def solution(price):
    # Another version created by referring to the model answer
    discount_rule = {500000: 0.8, 300000: 0.9, 100000: 0.95, 10: 1}

    for discount_price, discount_rate in discount_rule.items():
        if price >= discount_price:
            return int(price * discount_rate)