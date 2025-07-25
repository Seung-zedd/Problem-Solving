import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.merge(c[1], 1, Integer::sum);
        }

        // 카티션 프로덕트 - 1
        int ans = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans *= entry.getValue() + 1;
        }

        return ans - 1;
    }
}