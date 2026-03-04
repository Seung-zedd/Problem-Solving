import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 정답의 길이가 작업 진도의 길이와 맞지 않기 때문에 리스트로 초기화
        List<Integer> answer = new ArrayList<>();

        // 남은 개발 날짜를 의미하는 StagingQueue 초기화
        Queue<Integer> q = new ArrayDeque<>();

        // progresses를 순회하면서 계산
        for (int i = 0; i < progresses.length; i++) {
            // 남은 작업 진도 계산
            int remainedProgress = 100 - progresses[i];
            // 남은 개발 날짜를 계산
            int day = remainedProgress / speeds[i];
            int remained = remainedProgress % speeds[i];
            if (remained != 0) {
                day++;
            }

            // 스테이징 큐에 남은 개발 날짜를 순서대로 추가
            q.offer(day);
        }

        // 하루에 배포할 수 있는 기능 계산
        int feature = 0;
        while (!q.isEmpty()) {
            int maxDate = q.poll(); // 최고 날짜 업데이트
            feature++; // 큐에서 꺼낼 때마다 카운팅

            // ! 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 '함께' 배포됩니다. -> 부등호 주의!
            while (!q.isEmpty() && (maxDate >= q.peek())) {
                // 최고 날짜로 계속 업데이트(잡아먹는 구조)
                // maxDate = Math.max(maxDate, q.poll());
                q.poll(); //? while문이 단조 스택과 유사한 역할을 하기 때문에 maxDate는 유지됨
                feature++;
            }
            answer.add(feature);
            feature = 0; // 기능 개수 계산했으니까 다시 0으로 초기화
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}