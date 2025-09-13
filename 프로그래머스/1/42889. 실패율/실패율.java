import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. N을 for문을 돌리면서 실패율을 구한다.
        List<FailureRate> rateList = new ArrayList<>();

        // N을 점차 증가
        for (int i = 0; i < N; i++) {
            int numerator = 0; // N에 해당하는 수 카운팅
            int denominator = 0;
            int stageNum = i + 1;
            
            for (int j = 0; j < stages.length; j++) {
                // 분자
                if (stageNum == stages[j]) {
                    numerator++;
                }
                // 분모
                if (stageNum <= stages[j]) {
                    denominator++;
                }
            }
            
            // 실패율 계산 (j 루프 바깥에서)
            double rate = 0.0;
            if (denominator != 0) {
                rate = (double) numerator / denominator;
            }
            rateList.add(new FailureRate(stageNum, rate));
        }

        // 2. "각 스테이지의 번호"를 실패율(val)의 내림차순으로 정렬
        rateList.sort((r1, r2) -> {
            // 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다
            if (r1.rate == r2.rate) {
                return Integer.compare(r1.idx, r2.idx);
            } else {
                return Double.compare(r2.rate, r1.rate);
            }
        });

        // 3. 스테이지의 번호가 담겨있는 배열을 return
        List<Integer> numList = new ArrayList<>();
        for (FailureRate r : rateList) {
            numList.add(r.idx);
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class FailureRate {
        int idx;
        double rate;

        public FailureRate(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }
}
