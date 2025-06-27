import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 여사건 이용: 전체 경우의 수 - 알몸 상태인 1가지
        Map<String, Integer> map = new HashMap<>();

        for (String[] s : clothes) {
            map.merge(s[1], 1, Integer::sum);
        }

        // value를 뽑아서 각각 1씩 더하고 카티션 프로덕트
        int answer = 1;
        for (Integer i : map.values()) {
            answer *= i + 1;
        }

        return --answer;
    }
}