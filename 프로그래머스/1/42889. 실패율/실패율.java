import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2]; // 인덱스를 스테이지 번호에 맞추기 위해서(1 <= x <= N+1)
        for (int stage : stages) {
            challenger[stage] += 1; // stages의 val이 현재 스테이지에 멈춰있는 도전자 수
        }

        // 2. 스테이지별 실패한 사용자 수 계산
        Map<Integer, Double> failRate = new HashMap<>();
        double total = stages.length; // 여사건을 이용하기 위함

        // 3. 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i < N + 1; i++) {
            // 도전한 사람이 없는 경우, 실패율은 0
            if (challenger[i] == 0) {
                failRate.put(i, 0.0);
            } else {
                failRate.put(i, challenger[i] / total);
                total -= challenger[i]; // 여사건 적용
            }
        }
        
        // 4. 실패율이 높은 스테이지부터 내림차순 정렬
        // 실패율이 같으면 스테이지 번호 오름차순 정렬
        return failRate.entrySet()
                .stream()
                .sorted((o1, o2) ->
                        o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) : Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
