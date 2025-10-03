class Solution {
    public int[] solution(int n, long left, long right) {
        // left <= x <= right의 닫힌 구간
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
            long k = i + left; // 인덱스 k 설정
            int row = (int) (k / n);
            int col = (int) (k % n);

            // 값을 채움(zero-indexed 기준)
            // 대각성분은 row, col이 같고 i = 1부터 시작하기 때문에 1을 더함
            answer[i] = Math.max(row, col) + 1;
        }

        return answer;
    }
}