import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 1. 정현이가 원하는 고정된 품목 지도를 만듭니다. ( wantMap )
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 2. 현재 10일간의 현황판을 만듭니다. ( windowMap )
        Map<String, Integer> windowMap = new HashMap<>();
        // 3. [초기 세팅] 첫 10일(0~9)을 현황판에 기록합니다.
        for (int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }

        // 4. 첫 10일치가 완벽히 일치하는지 확인합니다.
        if (wantMap.equals(windowMap))
            answer++;

        // 5. [본격 슬라이딩] 10일차부터 끝까지 '나가는 놈'과 '들어오는 놈'만 처리합니다.
        for (int i = 10; i < discount.length; i++) {
            // A) 나가는 놈 처리 (i - 10일차 제품)
            String outItem = discount[i - 10];
            int outCount = windowMap.get(outItem);

            if (outCount == 1) {
                windowMap.remove(outItem); // 수량이 0이 되면 맵에서 완전히 제거해야 equals가 작동함
            } else {
                windowMap.put(outItem, outCount - 1);
            }
            // B) 들어오는 놈 처리 (i일차 제품)
            String inItem = discount[i];
            windowMap.put(inItem, windowMap.getOrDefault(inItem, 0) + 1);
            // C) 검증: 지도가 현황판과 일치하는가?
            if (wantMap.equals(windowMap))
                answer++;
        }
        return answer;
    }
}