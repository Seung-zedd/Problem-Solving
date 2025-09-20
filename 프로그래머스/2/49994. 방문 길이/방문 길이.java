import java.util.*;

class Solution {

    // 좌표평면을 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        return -5 <= nx && nx <= 5 && -5 <= ny && ny <= 5;
    }

    // 다음 좌표 결정을 위한 해시맵 생성
    private static final Map<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();
        int x = 0, y = 0;
        
        // 겹치는 좌표는 1개로 처리하기 위해 해시셋으로 초기화
        // edge 카운팅 용도
        Set<String> edges = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            // 좌표평면을 벗어나면 아래의 코드를 스킵
            if (!isValidMove(nx, ny)) {
                continue;
            }
            
            // A -> B와 B -> A는 같은 경우로 취급
            edges.add(x + " " + y + nx + " " + ny);
            edges.add(nx + " " + ny + x + " " + y);
            
            // 좌표를 이동했으므로 업데이트
            x = nx;
            y = ny;
        }

        return edges.size() / 2; // simple path이므로 2를 나눔
    }
}