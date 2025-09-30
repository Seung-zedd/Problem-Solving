import java.util.*;

class Solution {
    // 명령어를 좌표로 매핑
    // 불변 컬렉션은 solution 외부에서 초기화
    private static final Map<Character, int[]> map = new HashMap<>();

    private static void initLocation() {
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('L', new int[]{-1, 0});
        map.put('R', new int[]{1, 0});
    }

    private static boolean isValidMove(int nx, int ny) {
        return -5 <= nx && nx <= 5 && -5 <= ny && ny <= 5;
    }


    public int solution(String dirs) {
        initLocation();

        // 원점에서 시작
        int x = 0, y = 0;

        // path: 시점~종점 간의 경로로 해석 && 중복을 제거하기 위해 해시셋으로 초기화
        Set<String> edges = new HashSet<>();

        // 명령어에 따른 이동 시작
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = map.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];


            // 경계에 포함되면
            if (isValidMove(nx, ny)) {
                edges.add(x + "," + y + " " + nx + "," + ny);
                edges.add(nx + "," + ny + " " + x + "," + y);
                // 이동을 했으니까 좌표 업데이트
                x = nx;
                y = ny;
            }
        }

        return edges.size() / 2;
    }
}