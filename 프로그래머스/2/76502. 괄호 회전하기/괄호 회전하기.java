import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        // s를 먼저 순회
        for (int i = 0; i < s.length(); i++) {
            // s를 i만큼 회전
             count += rotateWithLeft(s, i);
        }

        return count;
    }

    private static int rotateWithLeft(String s, int i) {
        String result = s.substring(i) + s.substring(0, i);

        return isValidParenthesis(result) ? 1 : 0;
    }

    private static boolean isValidParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 열린 괄호면
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                // 스택이 비지 않았을 때 짝을 맞춘다
                if (!s.isEmpty()) {
                    if (s.peek() == '(' && c == ')' || s.peek() == '{' && c == '}' || s.peek() == '[' && c == ']') {
                        s.pop();
                    }
                } else {
                    //닫힌 괄호가 나오면 무조건 false
                    return false;
                }
            }
        }

        return s.isEmpty();
    }

    }