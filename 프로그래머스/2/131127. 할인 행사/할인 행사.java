import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        int day = 0;

        // 위시 리스트 담기
        for (int i = 0; i < want.length; i++) {
            wantMap.merge(want[i], number[i], Integer::sum);
        }

        // 10일차까지의 윈도우맵 세팅
        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            windowMap.merge(discount[i], 1, Integer::sum);
        }

        // 10일차까지 먼저 매칭
        if (wantMap.equals(windowMap)) {
            day++;
        }

        // 단일 슬라이딩 윈도우 시작
        for (int i = 10; i < discount.length; i++) {
            // 1. 나가는 품목
            String outItem = discount[i - 10];
            windowMap.computeIfPresent(outItem, (k, v) -> v == 1 ? null : v - 1);
            
            // 2. 들어오는 품목
            String inItem = discount[i];
            windowMap.merge(inItem, 1, Integer::sum); // 없으면 1추가, 있으면 기존의 value에 1 추가

            // 3. 매칭
            if (wantMap.equals(windowMap)) {
                day++;
            }
        }

        return day;
    }
}