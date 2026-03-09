import java.util.*;

class Solution {
    public int solution(int[] number) {
        int count = 0;
        int n = number.length;

        // x + y + z = 0에서 x를 상수로 고정(차원 하나를 고정시킴)
        for (int i = 0; i < n - 2; i++) {
            int x = number[i];
            int target = -x; // y + z = -x

            // two sum 응용, 즉 보수를 활용한다
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int y = number[j];
                int complement = target - y;

                // 이전에 저장한 해시맵에 보수가 있으면 위의 식이 성립하므로 그 개수만큼 정답 조합이 존재
                if (map.containsKey(complement)) {
                    count += map.get(complement);
                }

                // 그렇지 않으면 y값을 해시맵에 저장하여 다음 순회에서 보수의 후보로 만듦
                map.put(y, map.getOrDefault(y, 0) + 1);
            }
        }

        return count;
    }
}