import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!q.isEmpty() && (q.peekLast() == arr[i])) {
                continue;
            } else {
                q.offer(arr[i]);
            }
        }
        int[] answer = new int[q.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.pollFirst();
        }

        return answer;
    }
}