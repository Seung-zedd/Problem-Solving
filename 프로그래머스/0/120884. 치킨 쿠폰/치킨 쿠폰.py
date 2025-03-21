def solution(chicken):
    answer = 0
    coupon = chicken

    while coupon >= 10:
        # 쿠폰으로 받는 서비스 치킨 수
        service = coupon // 10
        answer += service
        # 남은 쿠폰 + 서비스 치킨으로 받은 새 쿠폰
        coupon = coupon % 10 + service
    return answer
