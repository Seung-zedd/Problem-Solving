import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐로 풀어보자
        // Integer를 내림차순으로 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            pq.offer(p);
        }

        // 프로세스 대기 큐 초기화
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        // 규칙 적용 시작
        int count = 0; // 실행 횟수

        // 어짜피 location에 있는 count를 리턴하면 되기 때문에 while문은 상관 x
        while (!q.isEmpty()) {
            // 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
            Process curProc = q.poll();
            int curVal = curProc.priority;
            int curIdx = curProc.idx;


            // 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
            if (pq.peek() == curVal) {
                count++;
                // 3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
                pq.poll();
                // 특정 프로세스(location)가 몇 번째로 실행?
                if (location == curIdx) {
                    return count;
                }
            } else {
                // 2. 큐에 대기중인 프로세스 중 "우선순위"가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
                q.offer(curProc);
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