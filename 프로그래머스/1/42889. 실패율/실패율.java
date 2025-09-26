import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 0은 dummy slot이라 공간 1 추가 + (N+1)에 해당하는 도전자 수도 할당해야 하므로 공간 1 추가
        int[] challengers = new int[N + 2];

        for (int i : stages) {
            challengers[i] += 1; // 각 원소는 현재 도전 중인 스테이지의 번호를 나타내므로 도전자 1 증가
        }

        // 실패율 계산: 스테이지 번호 N에 종속됨
        // key: stage 번호, value: 실패율
        int remain = stages.length; // 스테이지 길이는 각 테케마다 고정적이므로 전역변수로 설정

        Map<Integer, Double> failMap = new HashMap<>();
        // 입출력 예시를 통해 N번까지를 조건식으로 설정하면 됨
        for (int i = 1; i < N + 1; i++) {
            // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
            if (challengers[i] == 0) {
                failMap.put(i, 0.);
            } else {
                double failRate = (double) challengers[i] / remain;
                failMap.put(i, failRate);
                remain -= challengers[i];
            }
        }

        // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
        // 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
        List<Map.Entry<Integer, Double>> failList = new ArrayList<>(failMap.entrySet());

        failList.sort((e1, e2) -> e1.getValue() == e2.getValue() ? Integer.compare(e1.getKey(), e2.getKey()) : Double.compare(e2.getValue(), e1.getValue()));

        return failList.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}