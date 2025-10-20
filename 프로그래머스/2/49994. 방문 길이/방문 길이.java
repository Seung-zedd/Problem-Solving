import java.util.*;

class Solution {
    private static Map<Character, int[]> map = new HashMap<>();

    private static void initLocation() {
        map.put('U', new int[]{1, 0});
        map.put('D', new int[]{-1, 0});
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
    }

    private static boolean isValidMove(int nx, int ny) {
        return -5 <= nx && nx <= 5 && -5 <= ny && ny <= 5;
    }
    public int solution(String dirs) {
        // 명령어 초기화
        initLocation();

        // 캐릭터는 원점에서 시작
        int x = 0, y = 0;
        // 두 정점을 저장하기 위함
        Set<String> edges = new HashSet<>();

        // 명령어 파싱
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = map.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            // 좌표경계 안에 포함되면
            if (isValidMove(nx, ny)) {
                edges.add(x + "," + y + " " + nx + "," + ny);
                edges.add(nx + "," + ny + " " + x + "," + y);
                // 좌표 업데이트
                x = nx;
                y = ny;
            }
        }

        return edges.size() / 2;
    }
}