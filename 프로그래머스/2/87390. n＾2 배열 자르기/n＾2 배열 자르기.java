class Solution {
    public int[] solution(int n, long left, long right) {
        // 1차원 배열 생성
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
            // 포인터 생성
            long k = left + i;

            // row, col 공식
            //! Java에서 long / int 연산을 하면 int가 자동으로 long으로 형변환
            int row = (int) (k / n);
            int col = (int) (k % n);

            answer[i] = Math.max(row, col) + 1;
        }

        return answer;
    }
}