import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // answer는 10일 연속이 되는 총 날짜, target은 10일 연속
        int answer = 0, target = 0;

        // 해시맵 초기화
        Map<String, Integer> map = new HashMap<>();

        // discount를 순회하면서 슬라이딩 윈도우 시작
        for (int i = 0; i < discount.length; i++) {
            // 마찬가지로 map의 개수도 카운팅해주고 초기화도 해줘야하므로 for문 내에서 초기화
            for (int k = 0; k < want.length; k++) {
                map.put(want[k], number[k]);
            }

            target = 0; // 슬라이딩 될 때마다 타겟 다시 카운팅
            int start = i;
            int end = i + 9;

            for (int j = start; j < Math.min(end + 1, discount.length); j++) {
                if (map.containsKey(discount[j]) && map.get(discount[j]) > 0) {
                    target++;
                    map.put(discount[j], map.get(discount[j]) - 1); // 개수 감소
                }
            }
            // 슬라이딩 윈도우가 끝나면 타겟 검증 후 날짜 1 증가
            if (target == 10) {
                answer++;
            }
            // 맵도 다시 초기화
            map.clear();
        }

        return answer;
    }
}