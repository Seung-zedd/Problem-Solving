import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 행 번호를 먼저 완성(0번 ~ n-1번)
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 0번 이전은 없으므로 -1
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        // 행을 삭제 및 복구하기 위한 스택<행 번호를 저장>
        Deque<Integer> st = new ArrayDeque<>();

        // 표의 상태 == boolean으로 처리하라는 의미
        boolean[] isDeleted = new boolean[n];

        // cmd 순회
        for (String c : cmd) {
            Character command = c.charAt(0);

            switch (command) {
                case 'U':
                    int x = Integer.parseInt(c.substring(2));
                    // x만큼 이동
                    while (x-- > 0) {
                        k = prev[k]; // 현재 선택한 k행을 x만큼 위로 이동
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(c.substring(2));
                    while (y-- > 0) {
                        k = next[k]; // 현재 선택한 k행을 x만큼 아래로 이동
                    }
                    break;
                case 'C':
                    st.push(k); // 현재 선택한 행 제거
                    isDeleted[k] = true;
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }
                    // 선택된 행 삭제 > 아래 행으로 이동, 단 if 선택된 행 삭제 행이 마지막 행: 위로 이동
                    k = next[k] == -1 ? prev[k] : next[k];
                    break;
                case 'Z':
                    int z = st.pop();
                    isDeleted[z] = false;
                    // 연결 다시 조립
                    if (prev[z] != -1) {
                        next[prev[z]] = z;
                    }
                    if (next[z] != -1) {
                        prev[next[z]] = z;
                    }
                    // 단, 현재 선택된 행은 바뀌지 않습니다.
                    break;
            }
        }

        // 삭제되지 않은 행은 O, 삭제된 행은 X로 표시하여 문자열 형태로 return
        StringBuilder sb = new StringBuilder();

        for (boolean b : isDeleted) {
            if (b == true) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
    
        return sb.toString();
    }
}