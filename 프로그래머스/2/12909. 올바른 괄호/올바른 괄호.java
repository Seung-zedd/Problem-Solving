import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // String -> char로 바꿔서 하나씩 순회
            char c = s.charAt(i);

            if ((!stack.empty() && stack.peek() == '(') && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}