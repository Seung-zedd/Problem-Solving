import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        // course를 순회하면서 단품메뉴 조합 가지 수 탐색
        for (int i : course) {
            // 가지 수가 바뀔 때마다 초기화
            countMap.clear();
            for (String order : orders) {
                // 내부 오름차순 정렬을 하기 위해 먼저 toCharArray로 변환
                char[] beOrdered = order.toCharArray();
                Arrays.sort(beOrdered);
                String ordered = String.valueOf(beOrdered); // 다시 String으로 변환

                // 백트래킹 조합
                // 2^10 
                List<String> result = combine(ordered, i);

                // 분할 및 소집
                for (String r : result) {
                    // 집계
                    countMap.merge(r, 1, Integer::sum);
                }
            }
            // 최대 빈도수 탐색 && value >= 2로 검증
            int maxValue = Integer.MIN_VALUE;
            for (Integer v : countMap.values()) {
                maxValue = Math.max(maxValue, v);
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxValue && entry.getValue() >= 2) {
                    answer.add(entry.getKey());
                }
            }
        }

        // 외부 오름차순 정렬
        Collections.sort(answer);

        return answer.stream().toArray(String[]::new);
    }

    private List<String> combine(String ordered, int k) {
        List<String> ans = new ArrayList<>();
        List<Character> curr = new ArrayList<>();

        combineHelper(ordered, ans, curr, k, 0);

        return ans;
    }

    private void combineHelper(String ordered, List<String> ans, List<Character> curr, int k, int start) {
        // base condition
        if (curr.size() == k) {
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining())); // char 타입을 불변 객체인 String으로 변환해서 삽입
            return;
        }

        for (int i = start; i < ordered.length(); i++) {
            curr.add(ordered.charAt(i));
            combineHelper(ordered, ans, curr, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}