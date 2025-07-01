import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐로 초기화
        Queue<Process> q = new LinkedList<>();

        // 큐에 삽입
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i)); // 우선순위, 인덱스
        }

        int count = 0; // 실행 횟수

        while (!q.isEmpty()) {
            Process curProc = q.poll();

            int curVal = curProc.priority;
            int curIdx = curProc.idx;

            // 최댓값 탐색
            // 큐에서 poll할 때마다 maxVal을 초기화해줘야함
            int maxVal = 0;
            Iterator<Process> maxIter = q.iterator();
            while (maxIter.hasNext()) {
                Process nextProc = maxIter.next();
                int nextVal = nextProc.priority;

                maxVal = Math.max(maxVal, nextVal);
            }

            // priorities 길이가 1이라면? count + 1을 리턴
            if (q.isEmpty()) {
                return count + 1;
            } 

            Iterator<Process> iter = q.iterator(); // iterator 처음으로 초기화
            while (iter.hasNext()) {

                if (curVal < maxVal) {
                    q.offer(new Process(curVal, curIdx));
                    break;
                } else {
                    count++; // 현재 프로세스가 최댓값이므로 GC에 의해 수거하라고 하자
                    // 종료 조건
                    if (curProc.idx == location) {
                        return count;
                    }
                    break; // 종료시켰으니까 다시 q.poll()을 진행
                }

            }

        }

        return 0;
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