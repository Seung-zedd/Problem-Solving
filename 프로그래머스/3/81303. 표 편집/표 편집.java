import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        // ! 기존의 Node 객체로 더블링크드리스트를 구현하면 OOM이 터지니 배열 기반으로 구현
        // 객체 대신 인덱스로 연결하기(배열의 인덱스를 포인터처럼 사용)
        int[] prev = new int[n];
        int[] next = new int[n];

        // n만큼 초기화
        // 행 번호를 Node, prev[i] 또는 next[i]를 ptr.next라고 생각하자
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 0번 이전은 없으니까 -1 표시
            next[i] = i + 1; // 마찬가지로 n번 다음은 없으니까 그대로 n + 1 표시
        }
        next[n - 1] = -1; // n-1번째 다음은 없으므로 -1 표시

        // 삭제된 행 복구를 위한 스택
        // 행 번호를 그대로 더블리링크드리스트에 삽입하기 위해 행번호 int 타입을 사용
        Stack<Integer> s = new Stack<>();
        boolean[] isDeleted = new boolean[n];

        // cmd의 X를 i로 매핑
        for (String c : cmd) {
            // ! split()을 사용하면 result[1]을 참조하려고 하면 ArrayIndexOutOfBoundsException이 발생하기 때문에
            // 안전하게 substring으로 X를 파싱
            Character arrow = c.charAt(0);

            // 위에서 선언했던 배열 인덱스를 포인터로 사용(즉, 현재 가리키는 행인 k를 포인터로 사용)
            switch (arrow) {
                // U이면 X만큼 이동
                case 'U':
                    int x = Integer.parseInt(c.substring(2));
                    while (x-- > 0) {
                        k = prev[k]; // 이전 행으로 포인터를 갱신(≒ ptr = ptr.prev;)
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(c.substring(2));
                    while (y-- > 0) {
                        k = next[k]; // 다음 행으로 포인터를 갱신(≒ ptr = ptr.next;)
                    }
                    break;
                case 'C':
                    // 삭제한 행을 스택에 푸시하고 삭제된 행번호를 true로 마킹
                    s.push(k);
                    isDeleted[k] = true;

                    // 핵심: 가드 조건과 실행문의 인덱스를 일치시켜야 합니다!
                    // 1. 내 다음 행(next[k])이 있다면, 그 행의 이전(prev)을 내 이전(prev[k])으로 연결
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }
                    // 2. 내 이전 행(prev[k])이 있다면, 그 행의 다음(next)을 내 다음(next[k])으로 연결
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }

                    // 현재 위치 이동: 다음 행이 없으면 위로(마지막 행 삭제 시), 있으면 아래로
                    k = (next[k] == -1) ? prev[k] : next[k];
                    break;
                case 'Z':
                    // 삭제한 행을 다시 복구(Doubly Linked List의 insert와 유사)
                    int z = s.pop();
                    isDeleted[z] = false;
                    // prev[z]와 next[z]는 여전히 배열에 남아있기 때문에 그대로 z에만 연결
                    if (prev[z] != -1) {
                        next[prev[z]] = z; // prev[z]는 A
                    }
                    if (next[z] != -1) {
                        prev[next[z]] = z; // next[z]는 B
                    }
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();

        for (boolean b : isDeleted) {
            if (b == true) {
                sb.append("X"); // 삭제된 행은 X
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    };

}