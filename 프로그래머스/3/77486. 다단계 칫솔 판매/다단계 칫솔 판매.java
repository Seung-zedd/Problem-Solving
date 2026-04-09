import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // enroll - referral 맵 구성
        Map<String, String> referMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            referMap.put(enroll[i], referral[i]);
        }

        // seller - amount
        // 그런데, seller가 중복될 수 있으므로, seller[i]를 독립적인 이벤트라고 생각하고 상향 전파를 각각 실행
        Map<String, Integer> moneyMap = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            String curPerson = seller[i];
            int curMoney = amount[i] * 100;

            // referral이 "-"가 아니고 curMoney가 0원이 아닐 때까지 while문 반복(pruning 효과)
            // while문 안에서 현재 상태를 계속해서 상향 전파해야 하기 때문에 cur 변수를 그대로 사용
            // ? curPerson이 center가 아니고 남은 금액이 0원을 초과할 때만 상향 전파를 수행
            distribute(curPerson, curMoney, moneyMap, referMap);
        }

        // enroll을 순회하면서 이익금 answer에 저장
        for (int i = 0; i < enroll.length; i++) {
            String curPerson = enroll[i];
            answer[i] = moneyMap.getOrDefault(curPerson, 0); // enroll 명단에는 있지만 seller 명단에는 없는 경우
        }

        return answer;
    }

    private static void distribute(String person, int money, Map<String, Integer> moneyMap, Map<String, String> referMap) {
        // base condition
        // 상향 전파를 하지 않을 조건: 현재 사람이 center거나 돈이 0원이면 절사해서 배당금을 전달하지 않아도 됨
        //? while문의 여집합
        if (person.equals("-") || money == 0) {
            return;
        }

        // 상향 전파 시작
        int referMoney = money / 10;
        int myMoney = money - referMoney;

        // 내 돈을 먼저 챙김
        moneyMap.merge(person, myMoney, Integer::sum);

        // 나머지는 부모 노드로 위임
        distribute(referMap.getOrDefault(person, "-"), referMoney, moneyMap, referMap);
    }
}