import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int m = wallpaper.length; // 행
        int n = wallpaper[0].length(); // 열

        // 완전 탐색을 하면서 좌표값 모음
        // 모든 파일들의 좌표를 포함하는 최솟값 좌표와 최댓값 좌표를 모으기 위함
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        // 모은 좌표값을 배열로 리턴
        return new int[]{minR, minC, maxR + 1, maxC + 1};

    }
}