import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 스택 초기화
        Stack<Stock> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // 과거 가격 > 현재 가격이면 stack.pop()
            while (!s.isEmpty() && (s.peek().stockPrice > prices[i])) {
                Stock stock = s.pop();
                int idx = stock.idx;
                answer[idx] = i - idx; // 1초간 가격이 떨어지지 않음
            }

            s.push(new Stock(prices[i], i));

        }

        Iterator<Stock> iter = s.iterator();
        while (iter.hasNext()) {
            Stock next = iter.next();
            int idx = next.idx;
            answer[idx] = (prices.length - 1) - idx;
        }

        return answer;
    }

    private static class Stock {
        int stockPrice;
        int idx;

        public Stock(int stockPrice, int idx) {
            this.stockPrice = stockPrice;
            this.idx = idx;
        }
    }
}