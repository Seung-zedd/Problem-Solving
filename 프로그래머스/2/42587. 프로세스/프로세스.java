import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위 전용 우선순위 큐
        // 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int p : priorities) {
            pq.offer(p);
        }

        // 프로세스(우선순위, 인덱스)전용 큐 초기화
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        // 규칙 적용
        int count = 0;
        while (!q.isEmpty()) {
            Process curProc = q.poll();
            if (curProc.priority < pq.peek()) {
                q.offer(curProc);
            } else {
                pq.poll();
                count++;
                if (curProc.idx == location) {
                    return count;
                }
            }
        }

        return count;
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