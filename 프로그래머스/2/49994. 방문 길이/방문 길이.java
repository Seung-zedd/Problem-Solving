import java.util.*;

class Solution {

    private static final Map<Character, int[]> map = new HashMap<>();

    // 명령어 좌표에 매핑
    private static void initLocation() {
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('L', new int[]{-1, 0});
        map.put('R', new int[]{1, 0});
    }

    private static boolean isValidMove(int x, int y) {
        return -5 <= x && x <= 5 && -5 <= y && y <= 5;
    }

    public int solution(String dirs) {
        initLocation();

        // 캐릭터 위치 설정
        int x = 0, y = 0;

        // 캐릭터가 처음 걸어본 길의 길이를 구하기 위한 해시셋
        // 두 정점을 저장해서 식별
        Set<String> edges = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = map.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            // 좌표 경계에 포함되면
            if (isValidMove(nx, ny)) {
                edges.add(x + "," + y + " " + nx + "," + ny);
                edges.add(nx + "," + ny + " " + x + "," + y);
                // 경계에 포함되서 이동했으니까 좌표 업데이트
                x = nx;
                y = ny;
            } 
        }

        return edges.size() / 2;
    }
}