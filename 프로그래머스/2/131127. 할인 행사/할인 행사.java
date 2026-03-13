import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // [복습 1회차] 할인 행사
        int count = 0;

        // 단일 슬라이딩 윈도우 기법으로 문제 돌파
        Map<String, Integer> wantMap = new HashMap<>();
        // 제품, 수량 삽입(최대 길이 10)
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // discount 슬라이딩 윈도우 초기 세팅
        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            windowMap.merge(discount[i], 1, Integer::sum);
        }
        // 처음 1~10일차 비교
        if (wantMap.equals(windowMap)) {
            count++;
        }

        // 슬라이딩 윈도우 시작
        for (int i = 10; i < discount.length; i++) {
            String outItem = discount[i - 10];

            // A) 나가는 품목
            //? 수량이 1이면 연산 결과가 null이 되는 순간 해당 키를 즉시 remove, 그렇지 않으면 수량 1을 감소
            windowMap.computeIfPresent(outItem, (k, v) -> v == 1 ? null : v - 1);

            // B) 들어가는 품목
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