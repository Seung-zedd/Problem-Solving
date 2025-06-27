import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 해시맵
        Map<String, Integer> map = new HashMap<>();

        // 참가자 명단
        for (String p : participant) {
            map.merge(p, 1, Integer::sum);
        }

        // 완주자 명단
        for (String c : completion) {
            map.merge(c, 1, (x1, x2) -> x1 - x2);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }

        return "";
    }
}