import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // <종류, 개수> 카운팅
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.merge(cloth[1], 1, Integer::sum);
        }

        // (카테시안 곱 + 1) - 1
        //! 안 입는 경우도 선택지로 포함시키면 문제 구조가 훨씬 쉬워진다
        int mul = 1;
        for (int i : map.values()) {
            mul *= i + 1;
        }

        return mul - 1;
    }
}