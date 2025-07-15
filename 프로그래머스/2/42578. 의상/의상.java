import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 해시 맵<의상의 종류, 개수> 초기화
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.merge(c[1], 1, Integer::sum);
        }
        
        // 여사건: 전체 경우의 수 - 1
        // 카티션(map.values() + 1) - 1
        int answer = 1;
        for (Integer i : map.values()) {
            answer *= i + 1;
        }

        return answer - 1;
    }
}