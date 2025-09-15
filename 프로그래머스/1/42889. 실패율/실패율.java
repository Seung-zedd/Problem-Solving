import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 도전자의 수 계산
        // 0~N ->1~N+1 && N단계까지 클리어한 수
        int[] challenger = new int[N + 2];

        // stage 번호에 따른 도전자의 수 1씩 증가
        for (int stage : stages) {
            challenger[stage] += 1;
        }

        // 실패율 계산
        Map<Integer, Double> failRate = new HashMap<>();
        double total = stages.length;

        // i는 스테이지 번호에 맞춘다.
        for (int i = 1; i < N + 1; i++) {
            // edge case: 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
            if (challenger[i] == 0) {
                failRate.put(i, 0.0);
            } else {
                failRate.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        // 실패율이 높은 스테이지부터 내림차순
        // if (실패율이 같은 스테이지가 있다면): 작은 번호의 스테이지가 먼저 오도록 하면 된다.
        List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(failRate.entrySet());

        // 삼항 연산자
        return sortedList
                .stream()
                .sorted((s1, s2) ->
                        s1.getValue().equals(s2.getValue()) ? Integer.compare(s1.getKey(), s2.getKey()) : Double.compare(s2.getValue(), s1.getValue())
                ).mapToInt(Map.Entry::getKey).toArray();
    }
}