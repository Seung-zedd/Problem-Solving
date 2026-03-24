import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        // 1. 백트래킹을 사용해서 course[i]에 맞게 개수 조합
        // ? 조합의 2^N에서의 N은 orders[i].length를 의미하므로 2^10 = 1024
        for (int i : course) {
            // 2. 각 조합이 몇 번 발생했는지를 알기 위한 countMap
            // ? 왜냐하면 i가지 조합마다 다르게 빈도를 조사해야 하기 때문
            Map<String, Integer> countMap = new HashMap<>();
            for (String order : orders) {
                // order -> char[]로 변경
                char[] beOrdered = order.toCharArray();
                // 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
                //? 하나의 조합 키로 통일하여 집계하기 위해 내부 정렬(e.g. "XY" == "YX")
                Arrays.sort(beOrdered); 
                // char[] -> String
                String ordered = String.valueOf(beOrdered);

                List<String> result = combine(ordered, i);
                for (String r : result) {
                    countMap.merge(r, 1, Integer::sum);
                }
            }

            // 최대 빈도 수 탐색
            int maxValue = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                maxValue = Math.max(entry.getValue(), maxValue);
            }
            // 최소 2인 이상 검증
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                // 조합의 빈도 수가 2인 이상이면서 가장 많이 주문한 조합
                //! if (maxValue >= 2)만 작성하면 2 미만 이더라도 entry의 조합들이 저장될 수가 있어서 논리적 오류 발생!
                if (maxValue >= 2 && entry.getValue() == maxValue) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer); // 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return
        return answer.stream().toArray(String[]::new);
    }

    // 백트래킹 템플릿
    private static List<String> combine(String order, int r) {
        // 답변 리스트 초기화
        List<String> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), order, ans, 0, r);
        return ans;
    }

    private static void backtrack(List<Character> curr, String order, List<String> ans,
            int start, int r) {
        // base condition
        if (curr.size() == r) {
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining())); // Char 타입의 curr를 String으로 매핑하는데(화살표로 매핑하는 과정), Collectors를 사용해서 concatnate를 한다
            return;
        }
        // 후보군 탐색
        for (int i = start; i < order.length(); i++) {
            curr.add(order.charAt(i)); // 선택
            backtrack(curr, order, ans, i + 1, r); // i + 1부터 다시 탐색
            curr.remove(curr.size() - 1); // 마지막 원소 제거 (backtrack)
        }
    }
}