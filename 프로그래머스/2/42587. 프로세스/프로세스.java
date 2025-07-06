import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐 초기화 및 삽입
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        int count = 0;

        // 엣지 케이스
        if (priorities.length == 1) {
            return count + 1;
        }

        // 규칙 시작
        while (!q.isEmpty()) {
            // 규칙1
            Process curProc = q.poll();
            int curVal = curProc.priority;
            int curIdx = curProc.idx;

            // 우선순위 최댓값 탐색
            int maxVal = 0;
            Iterator<Process> iter = q.iterator();
            while (iter.hasNext()) {
                Process nextProc = iter.next();
                int nextVal = nextProc.priority;
                maxVal = Math.max(nextVal, maxVal);
            }

            // 규칙2
            if (curVal < maxVal) {
                q.offer(curProc);
            } else {
                count++;
                if (curIdx == location) {
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