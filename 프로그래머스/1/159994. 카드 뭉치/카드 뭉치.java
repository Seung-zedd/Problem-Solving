import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();

        // 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
        for (String c1 : cards1) {
            q1.offer(c1);
        }

        for (String c2 : cards2) {
            q2.offer(c2);
        }

        // 먼저 goal을 순회
        // goal의 단어를 하나씩 만들 수 있다면 ""로 변경
        int answer = goal.length;
        for (int i = 0; i < goal.length; i++) {
            if (!q1.isEmpty() && q1.peek().equals(goal[i])) {
                q1.poll();
                answer--;
            }
            if (!q2.isEmpty() && q2.peek().equals(goal[i])) {
                q2.poll();
                answer--;
            }
            // 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
            
        }

        return answer == 0 ? "Yes" : "No";
    }
}