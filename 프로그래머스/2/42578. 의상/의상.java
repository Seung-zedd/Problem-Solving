import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 옷 종류의 개수 계산
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        // 전체 경우의 수((각 옷 종류의 개수 + 미착용인 1)를 카티션 프로덕트) - 알몸
        int answer = 1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            answer *= e.getValue() + 1;
        }

        return --answer;

    }
}