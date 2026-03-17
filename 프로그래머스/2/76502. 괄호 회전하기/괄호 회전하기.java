import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        // 0 ≤ x < (s의 길이)로 회전하기 위해 그냥 s를 for문으로 순회
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String result = leftRotate(i, s);
            answer += validParenthesis(result);
        }
        return answer;
    }

    private static String leftRotate(int x, String s) {
        // 원형 큐 초기화
        Deque<Character> q = new ArrayDeque<>();
        // 원형 큐에 문자열 삽입
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        // 요세푸스 순열 응용
        for (int i = 0; i < x; i++) {
            q.offer(q.poll());
        }

        return q.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static int validParenthesis(String s) {
        // 스택 초기화
        Deque<Character> st = new ArrayDeque<>();
        // 스택에 문자열 삽입
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 짝이 맞으면 pop()
            if (!st.isEmpty() && ((st.peekLast() == '(' && c == ')') || st.peekLast() == '{' && c == '}' || st
                    .peekLast() == '[' && c == ']')) {
                st.pollLast();
            } else if (c == ')' || c == '}' || c == ']') {
                return 0;
            }
            // 열린 괄호는 무조건 push
            else {
                st.offer(c);
            }
        }

        return st.isEmpty() ? 1 : 0;

    }
}