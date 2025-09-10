import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 패턴 분석
        int[][] patterns = {{
                1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 정답과 패턴을 비교
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 최고점수를 찾는다
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }

        // 최고점수의 수포자를 찾는다
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (maxScore == scores[i]) {
                numList.add(i + 1);
            }
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}