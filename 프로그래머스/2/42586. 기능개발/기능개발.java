
import java.util.*;
import java.lang.Math.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] workTimeArr = new int[speeds.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remained = 100 - progresses[i];
            workTimeArr[i] = (int) Math.ceil((double) remained / speeds[i]); // 나누기 연산자는 소수점을 truncate하기 때문에 나누기 결과를 double로 바꾸고 소수점을 올려서 int로 계산함
        }

        // 작업 가능한 날짜를 큐에 삽입
        for (int i = 0; i < workTimeArr.length; i++) {
            q.offer(workTimeArr[i]);
        }

        List<Integer> deployDay = new ArrayList<>();

        while (!q.isEmpty()) {
            int count = 0; // 큐를 꺼낼때마다 개수 세기 위함
            Integer firstWorkTime = q.poll();
            count++;
            while (!q.isEmpty() && (firstWorkTime >= q.peek())) {
                q.poll();
                count++;
            }
            deployDay.add(count);
        }

        int[] answer = new int[deployDay.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deployDay.get(i);
        }

        return answer;

    }
}