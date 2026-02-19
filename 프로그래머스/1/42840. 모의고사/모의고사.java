import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자가 찍는 방식 map으로 초기화
        Map<Integer, int[]> map = new HashMap<>();
        init(map);
        int[] scores = new int[4]; //! 수포자가 맞힌 점수 배열(idx는 수포자 번호 그대로 매핑) && 인덱스 0은 버퍼로 사용

        for (int i = 0; i < answers.length; i++) {
            // map의 시간복잡도는 O(1)이므로, O(N) * O(1) = O(N)이므로 내부 루프 가능!
            for (Map.Entry<Integer, int[]> e : map.entrySet()) {
                //! value 배열에서 '%' 연산자를 포함한 인덱싱으로 answers[i]와 직접 비교해야 answers 값과 수포자의 정답을 1대1 매핑해서 검사를 할 수가 있다
                if (e.getValue()[i % e.getValue().length] == answers[i]) {
                    scores[e.getKey()]++;
                }

            }
        }

        // 먼저 가장 높은 점수 업데이트
        int maxScore = Integer.MIN_VALUE;
        for (int i = 1; i < scores.length; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }

        // if 가장 높은 점수를 받은 사람 > 1: return하는 배열을 오름차순 정렬
        //? 수포자 번호를 담기 위해 리스트 초기화
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i < scores.length; i++) {
            if (maxScore == scores[i]) {
                numList.add(i); // 최고 점수를 받은 인덱스(사람)을 그대로 추가
            }
        }

        //! 아래와 같이 정렬하면 인덱스 순서도 정렬이 되기 때문에 망함!
        // if (count > 1) {
        //     Arrays.sort(scores);
        // }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void init(Map<Integer, int[]> map) {
        map.put(1, new int[] { 1, 2, 3, 4, 5 });
        map.put(2, new int[] { 2, 1, 2, 3, 2, 4, 2, 5 });
        map.put(3, new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 });
    }
}