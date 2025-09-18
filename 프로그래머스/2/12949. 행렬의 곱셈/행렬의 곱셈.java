class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 2차원 배열을 보면 제일 먼저 row, col을 변수에 저장
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // (m x k) x (k x n) = m x n
        // k는 공유 차원에 참여하는 열벡터

        // 최종 곱해진 행렬 크기는 r1 x c2
        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}