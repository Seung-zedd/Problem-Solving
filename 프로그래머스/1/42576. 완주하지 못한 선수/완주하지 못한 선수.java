import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        // 먼저 참가자 수를 순회하면서 카운팅을 한다
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 수를 순회하면서 참가자 수와 매칭
        for (String c : completion) {
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
        }
        
        // 다시 참가자 수를 순회하면서 카운팅된 값이 남아있으면 그것이 곧 완주하지 못한 선수
        for (String p : participant) {
            if (map.get(p) != 0) {
                return p;
            }
        }
        
        return "";
    }
}