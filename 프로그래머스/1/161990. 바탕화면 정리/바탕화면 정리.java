import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int m = wallpaper.length;
        int n = wallpaper[0].length();

        // 먼저 완전 탐색으로 파일 개수 파악(어짜피 최댓값은 50이라 10^2이므로 쌉가능)
        //* 수정: 파일의 좌표를 리스트에 추가

        char[][] grid = new char[m][n];
        // String 1차원 배열 -> char[] 2차원 배열(String은 객체 타입이라 인덱싱 접근이 안되므로)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = wallpaper[i].charAt(j);
                grid[i][j] = c;
            }
        }

        // 완전 탐색으로 totalFile의 좌표를 일단 모음
        // "모든 파일"을 제거해야 하기 위해 totalFile도 카운팅
        int totalFile = 0;
        List<Integer> rList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    rList.add(i);
                    cList.add(j);
                    totalFile++;
                }
            }
        }

        // 좌표 오름차순으로 정렬
        rList.sort(Integer::compare);
        cList.sort(Integer::compare);


        // 최솟값, 최댓값 추출
        Integer minR = rList.get(0);
        Integer minC = cList.get(0);
        Integer maxR = rList.get(rList.size() - 1) + 1;
        Integer maxC = cList.get(cList.size() - 1) + 1;

        return new int[]{minR, minC, maxR, maxC};
    }
}