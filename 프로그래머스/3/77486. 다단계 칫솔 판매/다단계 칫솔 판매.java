import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> referMap = new HashMap<>();
        // enroll - referral
        for (int i = 0; i < enroll.length; i++) {
            referMap.put(enroll[i], referral[i]); // "-"는 center를 의미
        }

        // 이익금 계산
        Map<String, Integer> moneyMap = new HashMap<>();
        for (int i = 0; i < amount.length; i++) {
            int curMoney = amount[i] * 100;
            String curPerson = seller[i]; // 현재 노드

            // 부모 노드가 없고 10%를 계산한 금액이 1 원 미만이면 false
            // ! 문자열 내용 비교는 항상 equals를 사용합시다
            // ? 아래의 while문은 부모 노드로 계속 전파하는 구조라서 현재 상태를 먼저 수행
            while (!curPerson.equals("-") && curMoney != 0) {
                int referMoney = curMoney / 10;
                int myMoney = curMoney - referMoney;
                // 내 돈을 먼저 챙김
                moneyMap.merge(curPerson, myMoney, Integer::sum);
                // 나머지를 부모 노드로 위임
                curPerson = referMap.getOrDefault(curPerson, "-");
                curMoney = referMoney;
            }
        }
        //! center는 애초에 "enroll에 민호의 이름은 없습니다."고 했기 때문에 고려하지 않아도 됨

        // 최종 이익금 계산
        for (int i = 0; i < enroll.length; i++) {
            // ! "sam"은 seller에 없고 리프 노드에 해당하기 때문에 0원 발생
            int money = moneyMap.getOrDefault(enroll[i], 0);
            answer[i] = money;
        }

        return answer;
    }
}