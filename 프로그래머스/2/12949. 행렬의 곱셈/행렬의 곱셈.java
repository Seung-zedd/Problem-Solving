import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 행렬 곱의 size = (m x k) x (k x n) = m x n
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        int[][] answer = new int[r1][c2]; // 리턴할 정답 배열

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                // 내부 차원에서의 성분 곱
                for (int k = 0; k < Math.min(c1, r2); k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}