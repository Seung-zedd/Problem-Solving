import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 0은 더미 슬롯, N+1 도전자 수도 포함
        int[] challengers = new int[N + 2];

        for (int s : stages) {
            challengers[s] += 1;
        }

        // 실패율 계산
        Map<Integer, Double> failMap = new HashMap<>();
        int total = stages.length;

        for (int i = 1; i < N + 1; i++) {
            // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
            if (challengers[i] == 0) {
                failMap.put(i, 0.);
            } else {
                double failRate = (double) challengers[i] / total;
                failMap.put(i, failRate);
                total -= challengers[i]; // 스테이지 레벨을 올리기 전에 이전에 도달한 스테이지 사람들을 제외
            }
        }

        // 실패율이 높은 스테이지부터 내림차순
        // 만약 실패율이 같은 스테이지가 있다면 스테이지 번호 오름차순(stable)
        return failMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().equals(e2.getValue()) ? Integer.compare(e1.getKey(), e2.getKey()) : Double.compare(e2.getValue(), e1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}