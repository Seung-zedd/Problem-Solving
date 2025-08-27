import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int m = wallpaper.length;
        int n = wallpaper[0].length();
        
        
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        // 완전 탐색 안에서 좌표의 극단값 찾기
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

        return new int[]{minR, minC, maxR + 1, maxC + 1};
    }
}