import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 1. 해시맵 초기화 후 wantMap에 <want, number>를 먼저 담음
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.merge(want[i], number[i], Integer::sum);
        }

        // 2. windowMap에도 우선 초기 10일차의 품목을 담음
        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            windowMap.merge(discount[i], 1, Integer::sum);
        }

        // 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
        int count = 0;
        if (wantMap.equals(windowMap)) {
            count++;
        }

        // 3. 단일 루프 슬라이딩 윈도우 시작
        for (int i = 10; i < discount.length; i++) {
            // A) 나가는 품목
            String outItem = discount[i - 10];
            windowMap.computeIfPresent(outItem, (k, v) -> v == 1 ? null : v - 1); // 1이면 아예 null을 리턴해서 품목을 없앰

            // B) 들어오는 품목
            String inItem = discount[i];
            windowMap.merge(inItem, 1, Integer::sum);

            // C) 검증
            if (wantMap.equals(windowMap)) {
                count++;
            }
        }

        return count;
    }
}