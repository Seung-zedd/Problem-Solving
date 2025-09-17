import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자의 패턴을 먼저 분석
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 수포자의 정답을 맞춘 개수 카운팅
        int[] scores = new int[3];
        int maxScore = Integer.MIN_VALUE;

        // 정답과 수포자의 패턴 비교
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 최고점 파악
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }

        // 수포자 번호를 저장하기 위한 리스트
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                numList.add(i + 1);
            }
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}