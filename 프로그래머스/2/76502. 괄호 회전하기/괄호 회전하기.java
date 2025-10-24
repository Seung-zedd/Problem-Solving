import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += rotateToLeft(s, i);
        }

        return count;
    }

    private static int rotateToLeft(String s, int k) {
        String result = s.substring(k) + s.substring(0, k);
        return isValidParenthesis(result) ? 1 : 0;
    }

    private static boolean isValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 열린괄호 먼저 처리
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫힌 괄호인데 스택이 비어있지 않다면
                if (!stack.isEmpty()) {
                    // 짝을 맞춰서
                    if (stack.peek() == '(' && c == ')' || stack.peek() == '{' && c == '}' || stack.peek() == '[' && c == ']') {
                        // 팝을 시킨다
                        stack.pop();
                    }
                } else {
                    // 스택이 비어있고 닫힌 괄호는 무조건 false
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}