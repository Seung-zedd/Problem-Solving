import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 순서를 위해 덱을 기반으로 하는 큐 생성
        Deque<Integer> q = new ArrayDeque<>();

        // 남은 개발 일짜 계산
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];

            // 나누어 떨어지지 않으면 day 1 증가
            if (remain != 0) {
                day++;
            }

            q.offer(day);
        }
        
        // 배포 날짜 계산 시작
        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int feature = 0;
            int maxDate = q.poll();
            feature++; // 꺼냈으면 기능 1 추가
            // 단조 스택의 맹공 스킬을 활용해서 계속해서 잡아먹는다
            while (!q.isEmpty() && (maxDate >= q.peek())) {
                q.poll();
                feature++; 
            }

            answer.add(feature);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}