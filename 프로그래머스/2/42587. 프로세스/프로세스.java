import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 프로세스 우선순위만 저장(내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int p : priorities) {
            pq.offer(p);
        }

        // 규칙을 위한 프로세스 대기 큐 생성
        Queue<Process> q = new LinkedList<>();

        // 대기 큐에 프로세스 배열 삽입
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        // 규칙 시작
        int count = 0; // 실행 횟수
        while (!q.isEmpty()) {
            Process curProc = q.poll();

            // 대기 큐에 우선순위가 더 높은 프로세스가 있다면
            if (curProc.priority != pq.peek()) {
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