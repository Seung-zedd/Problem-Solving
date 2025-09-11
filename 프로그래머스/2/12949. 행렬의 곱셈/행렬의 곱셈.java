import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 행렬의 행과 열을 변수에 저장
        // (m x k) x (k x n) = m x n
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 행렬 크기 초기화
        int[][] answer = new int[r1][c2];

        // 2. 행렬의 곱을 반복문으로 실행
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    // 행벡터 x 열벡터
                    answer[i][j] += arr1[i][k] *arr2[k][j];
                }
            }
        }

        return answer;
    }
}