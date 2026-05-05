import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 서로 다른 귤의 종류를 먼저 카운팅
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.merge(t, 1, Integer::sum);
        }

        // 내림차순 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 정렬된 리스트 내에서 k - list.values()
        int answer = 0; // 서로 다른 종류의 수
        for (Map.Entry<Integer, Integer> entry : list) {
            k -= entry.getValue();
            answer++;

            // k개의 귤을 다 담았으면 종료
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}