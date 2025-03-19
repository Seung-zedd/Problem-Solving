def solution(score):
    # 1. 각 학생의 평균 점수를 계산
    score_avg = [(e + m) / 2 for e, m in score]
    # 2. 내림차순 정렬
    score_avg_sorted = sorted(score_avg ,reverse=True)
    # 3. 등수를 매기기위한 딕셔너리
    score_avg_rank = {} # {score_val: idx + 1}

    for idx, score_val in enumerate(score_avg_sorted):
        # 중복 처리(동일한 key가 있으면 value는 업데이트되기 때문)
        if score_val not in score_avg_rank:
            score_avg_rank[score_val] = idx + 1
    # 평균 점수를 기준으로 학생들의 등수를 리턴
    return [score_avg_rank[score_val] for score_val in score_avg]