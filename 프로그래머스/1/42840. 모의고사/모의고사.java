import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 패턴 분석
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 정답 카운팅하기 위한 scores 배열 초기화
        int[] scores = new int[3];

        // 패턴과 정답 비교
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;

        // 최고 점수 업데이트
        for (int s : scores) {
            maxVal = Math.max(maxVal, s);
        }

        // 가장 높은 점수를 리턴하기 위한 리스트
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxVal) {
                numList.add(i + 1);
            }
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}