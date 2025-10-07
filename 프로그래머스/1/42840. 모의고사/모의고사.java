import java.util.*;

class Solution {
    // 읽기 전용 2차원 배열
    private static final int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        // 수포자 정답 저장용
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            // 수포자의 답들을 정답과 순서대로 비교
            // j는 row
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Integer.MIN_VALUE;

        // 최고 점수 업데이트
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                numList.add(i + 1);
            }
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}