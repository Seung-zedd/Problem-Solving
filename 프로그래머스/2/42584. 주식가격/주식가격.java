import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // prices의 idx와 val을 저장하기 위함
        Stack<int[]> s = new Stack<>();

        // ans 초기화
        int[] ans = new int[prices.length];

        // prices 순회
        for (int i = 0; i < prices.length; i++) {
            // 가격이 떨어지면 pop && null-safety
            while (!s.isEmpty() && s.peek()[1] > prices[i]) {
                int[] result = s.pop();
                int idx = result[0];
                ans[idx] = i - idx;
            }  
                s.push(new int[] { i, prices[i] });           
        }

        // 스택에 남아있는 값 후처리
        while (!s.isEmpty()) {
            int[] result = s.pop();
            int idx = result[0];
            ans[idx] = (prices.length - 1) - idx;
        }

        return ans;
    }
}