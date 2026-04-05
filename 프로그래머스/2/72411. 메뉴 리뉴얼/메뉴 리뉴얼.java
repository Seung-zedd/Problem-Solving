import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> countMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        // 1. course를 순회
        for (int c : course) {
            // 단품메뉴 배열을 순회
            for (String o : orders) {
                // 오름차순 정렬
                char[] beOrdered = o.toCharArray();
                Arrays.sort(beOrdered);
                String ordered = String.valueOf(beOrdered);
                List<String> result = combine(ordered, c);
                for (String r : result) {
                    countMap.merge(r, 1, Integer::sum);
                }
            }

            // 최대 빈도수 탐색 && value >= 2로 검증
            // 1. 최대 빈도수 탐색
            int maxVal = Integer.MIN_VALUE;
            for (Integer v : countMap.values()) {
                maxVal = Math.max(maxVal, v);
            }

            // 2. value >= 2 검증
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxVal && entry.getValue() >= 2) {
                    answer.add(entry.getKey());
                }
            }

            countMap.clear();
            Collections.sort(answer);
        }
        return answer.stream().toArray(String[]::new);
    }

    private static List<String> combine(String ordered, int r) {
        List<String> result = new ArrayList<>();
        Deque<Character> curr = new ArrayDeque<>();
        combineHelper(ordered, result, curr, r, 0);

        return result;
    }

    private static void combineHelper(String ordered, List<String> result, Deque<Character> curr, int r, int start) {
        // base condition
        if (curr.size() == r) {
            result.add(curr.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        for (int i = start; i < ordered.length(); i++) {
            char c = ordered.charAt(i);
            curr.addLast(c); // push()
            combineHelper(ordered, result, curr, r, i + 1); // 잠수
            curr.removeLast(); // pop()
        }
    }
}