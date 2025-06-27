import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        // String -> char로 바꿔서 하나씩 순회
        for (char c : s.toCharArray()) {
            if ((!stack.empty() && stack.peek() == '(') && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.empty();
    }
}