import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 인덱스 0은 더미 슬롯 &&  N + 1 스테이지에 도전 중인 사람
        int[] challengers = new int[N + 2];

        // 도전자 수 카운팅
        for (int stage : stages) {
            challengers[stage] += 1;
        }

        // {idx, failRate}
        Map<Integer, Double> failMap = new HashMap<>();
        int total = stages.length;

        // 스테이지 번호
        for (int i = 1; i < N + 1; i++) {
            // 스테이지에 도달한 유저가 없으면 실패율을 0으로 정의
            if (challengers[i] == 0) {
                failMap.put(i, 0.);
            } else {
                double failRate = (double) challengers[i] / total;
                failMap.put(i, failRate);
            }

            // 스테이지 번호가 올라갈 때마다 도전자의 수를 감소
            total -= challengers[i];
        }

        // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
        // if 실패율이 같으면 작은 번호 스테이지 오름차순
        return failMap.entrySet()
                .stream()
                // 스트림의 중간 연산
                .sorted((e1, e2) -> e1.getValue() == e2.getValue() ? Integer.compare(e1.getKey(), e2.getKey()) : Double.compare(e2.getValue(), e1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}