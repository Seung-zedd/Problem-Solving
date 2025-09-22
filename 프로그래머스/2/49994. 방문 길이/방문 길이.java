import java.util.*;

class Solution {
    public int solution(String dirs) {
        // 캐릭터는 원점부터 시작
        int x = 0, y = 0;

        // 명령어 -> 좌표이동으로 매핑
        initLocation();

        // 명령어 순회
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            // 좌표평면 범위를 통과하면
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

    private static final Map<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    private static boolean isValidMove(int nx, int ny) {
        return -5 <= nx && nx <= 5 && -5 <= ny && ny <= 5;
    }

    private static Set<String> edges = new HashSet<>();
}