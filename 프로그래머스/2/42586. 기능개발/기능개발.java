import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();

        // 하루에 배포 가능한 날짜를 계산
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            int remained = (100 - progresses[i]) % speeds[i];

            // 나누어떨어지지 않았으면 date 1 추가
            if (remained != 0) {
                day += 1;
            }

            // 계산한 날짜를 큐에 담는다
            q.offer(day);
        }

        // 하루에 배포 가능한 기능 개수 카운팅
        // 테케를 보면 파라미터의 배열 길이와 리턴 배열 길이가 일치하지 않기 때문에 가변 배열인 리스트 사용
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            // 큐를 순회할 때마다 기능 계산 시작
            int feature = 0;
            int maxDate = q.poll();
            feature++; // 큐에서 꺼냈으면 기능 카운팅

            while (!q.isEmpty() && maxDate >= q.peek()) {
                q.poll();
                feature++;
            }
            
            ans.add(feature);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}