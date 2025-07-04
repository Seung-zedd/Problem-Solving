import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 우선순위 큐에는 우선순위 값만 내림차순으로 저장
        //? 가장 높은 값을 빠르게 peek 하기 위해
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int priority : priorities) {
            pq.offer(priority);
        }

        // 2. 일반 큐에는 원래 순서를 지키기 위해 프로세스(우선순위, 인덱스)를 삽입
        Queue<Process> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        int exeCount = 0; // 실행횟수

        // 규칙 적용 시작
        while (!q.isEmpty()) {
            Process curProc = q.poll();

            // 현재 남아있는 가장 높은 우선순위(pq.peek())와 비교
            if (curProc.priority == pq.peek()) {
                exeCount++;
                pq.poll(); // 가장 높은 우선순위가 실행되었으므로 우선순위 큐에서도 제거
                if (curProc.idx == location) {
                    return exeCount;
                }
            } else {
                // 대기 큐에 더 높은 우선순위가 존재한다면 대기 큐에 다시 삽입
                q.offer(curProc);
            }
        }

        return exeCount;
    }

    private static class Process {
        int priority;
        int idx;

        public Process(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}