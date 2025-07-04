import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐로 초기화
        Queue<Process> q = new LinkedList<>();
        int execCount = 0; // 프로세스 실행 횟수

        // 엣지 케이스(우선순위 배열 길이가 1일 때는 count + 1을 리턴)
        if (priorities.length == 1) {
            return execCount + 1;
        }

        // 큐에 우선순위 원소 삽입(우선순위, 인덱스)
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
        }

        // 규칙 설정
        while (!q.isEmpty()) {
            // 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
            Process curProc = q.poll();
            int curVal = curProc.priority;
            int curIdx = curProc.idx;

            // 반복자를 통해 우선순위 최댓값을 큐의 원소를 제거할 때마다 갱신
            Iterator<Process> iterMax = q.iterator();
            int maxVal = 0;

            while (iterMax.hasNext()) {
                Process iterCurProc = iterMax.next();
                int iterCurVal = iterCurProc.priority;

                maxVal = Math.max(maxVal, iterCurVal); // 최댓값 업데이트
            }

            // 2. 큐에 대기중인 프로세스 중 "우선순위가 더 높은 프로세스"가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
            if (curVal < maxVal) {
                q.offer(new Process(curVal, curIdx));
            } else {
                //  3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
                execCount++;
                // 해당 프로세스를 실행시키고 나서
                // 요구사항: 해당 프로세스가 몇 번째로 실행되는지 return을 수행
                // 현재 프로세스의 인덱스가 location과 같다면 실행횟수를 리턴
                //! 이미 큐 내에서 현재 인덱스와 파라미터의 location을 비교하고 있기 때문에 targetProc은 불필요
                if (curIdx == location) {
                    return execCount;
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