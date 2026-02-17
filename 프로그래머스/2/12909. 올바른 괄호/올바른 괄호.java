import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        // s 순회
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            // 괄호가 짝지어져있으면 팝
            if (!st.isEmpty() && st.peek() == '(' && c == ')') {
                st.pop();
                // 닫힌 괄호가 먼저 오면 false
            } else if (st.isEmpty() && c == ')') {
                return false;
            } else {
                st.push(c);
            }
        }

        return st.empty();
    }
}