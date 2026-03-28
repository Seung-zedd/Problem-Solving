import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // course를 순회하면서 단품메뉴 조합 가지 수 탐색
        // countMap은 힙 메모리 절약을 위해 지역변수로 초기화한다, but 해시맵에 저장을 하고 나면 반드시 clear()해준다.
        Map<String, Integer> countMap = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i : course) {
            // 2-Pass 전략: 먼저 해시맵으로 조합 집계
            for (String order : orders) {
                // 내부 오름차순 정렬
                char[] beOrdered = order.toCharArray();
                Arrays.sort(beOrdered);
                String ordered = String.valueOf(beOrdered);
                List<String> result = combine(ordered, i); // 백트래킹 조합(T.C.:2^10 = 1024)
                for (String r : result) {
                    countMap.merge(r, 1, Integer::sum);
                }
            }

            // 분할 및 소집
            int maxValue = Integer.MIN_VALUE;
            for (Integer v : countMap.values()) {
                maxValue = Math.max(maxValue, v);
            }

            // 2. 최대 빈도수 및 value >= 2 검증
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxValue && entry.getValue() >= 2) {
                    ans.add(entry.getKey());
                }
            }

            countMap.clear();
        }
        // 외부 정렬
        Collections.sort(ans);

        return ans.stream().toArray(String[]::new);
    }

    private static List<String> combine(String str, int k) {
        List<String> ans = new ArrayList<>();
        List<Character> curr = new ArrayList<>();

        combineHelper(str, ans, curr, k, 0);
        return ans;
    }

    private static void combineHelper(String str, List<String> ans, List<Character> curr, int k, int start) {
        // base condition
        if (curr.size() == k) {
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining()));
        }
        

        for (int i = start; i < str.length(); i++) {
            curr.add(str.charAt(i));
            combineHelper(str, ans, curr, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}