import java.util.*;

class Solution {
    public int[] solution(int[] answers){
        // 1. 수포자들의 문제를 찍는 패턴을 분석(2차원 배열)
        //! return 할 때의 index는 자연수가 되어야 한다.
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 2. 수포자들의 점수를 저장할 배열 초기화
        // index == 수포자의 번호, value = 수포자의 맞은 점수
        int[] scores = new int[3];

        // 3. 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인
        // 만약에 len(answers) > len(patterns)면? -> patterns를 % 연산자를 이용해서 반복
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                // Pain Point: 나머지 연산자를 사용해서 남은 문제들을 patterns의 col에 매칭시킴
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 4. 가장 높은 점수를 저장
        int maxScore = Integer.MIN_VALUE;
        
        // scores의 value를 업데이트
        for (int i = 0; i < scores.length; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }

        // 5. 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            // scores의 인덱스를 리스트에 삽입
            if (maxScore == scores[i]) {
                numList.add(i + 1);
            }
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}