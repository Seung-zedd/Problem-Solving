import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // map: <의상의 종류, 의상 종류의 개수>
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 안 입는 경우도 포함
        Stack<Integer> stack = new Stack<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            stack.push(e.getValue() + 1);
        }

        int answer = 1;
        while (!stack.empty()) {
            answer *= stack.pop();
        }

        return --answer;

    }
}