import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 대기 큐 초기화
        Queue<Process> q = new LinkedList<>();
        int count = 0;

        // 큐에 우선순위 배열 삽입
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        // edge case
        if (priorities.length == 1) {
            return count + 1;
        }
        
        // 규칙 적용 시작
        while (!q.isEmpty()) {
            // 규칙1: 대기 큐에 있는 프로세스를 꺼낸다.
            Process curProc = q.poll();
            int curVal = curProc.priority;
            int curIdx = curProc.idx;

            // 반복자를 통해 우선순위 최댓값 탑색
            int maxVal = 0;
            Iterator<Process> maxIter = q.iterator();
            //! for-each문은 ConcurrentModifiedException 터짐
            while (maxIter.hasNext()) {
                Process cur = maxIter.next();
                int nextVal = cur.priority;
                maxVal = Math.max(maxVal, nextVal);
            }

            // 규칙2: 현재 프로세스보다 대기 큐에 더 우선순위가 높으면 다시 푸시
            if (curVal < maxVal) {
                q.offer(new Process(curVal, curIdx));
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