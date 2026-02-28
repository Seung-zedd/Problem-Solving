import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // ! 기존의 Node 객체로 더블링크드리스트를 구현하면 OOM이 터지니 배열 기반으로 구현
        // 객체 대신 인덱스로 연결하기(배열의 인덱스를 포인터처럼 사용)
        int[] prev = new int[n];
        int[] next = new int[n];

        // n만큼 초기화
        // ? prev[i] 또는 next[i]는 행 번호이면서 동시에 포인터 역할을 함
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
                        k = prev[k]; // int 타입은 값을 복사하므로, k가 이전 행으로 업데이트(≒ ptr = ptr.prev;)
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(c.substring(2));
                    while (y-- > 0) {
                        k = next[k]; // 마찬가지로 k가 다음 행으로 업데이트(≒ ptr = ptr.next;)
                    }
                    break;
                case 'C':
                    // 삭제한 행을 스택에 푸시하고 삭제된 행번호를 true로 마킹
                    s.push(k);
                    isDeleted[k] = true;

                    // ? 행끼리 연결하기 위해서는 행이 존재해야 된다, 즉 prev[k] 또는 next[k]가 존재해야 한다는 말
                    //* Singly Linked List가 익숙하기 때문에 다음 행 연결을 먼저 작성하였음.
                    // "2번 말고 3번으로 가!"가 실행되기 위해서는 k가 가리키고 있는 행의 이전 행이 존재해야 함
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    // "2번 말고 1번으로 가!"가 실행되기 위해서는 k가 가리키고 있는 행의 다음 행이 존재해야 함
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }

                    // 현재 위치 이동: 다음 행이 없으면 위로(마지막 행 삭제 시), 있으면 아래로
                    k = (next[k] == -1) ? prev[k] : next[k];
                    break;
                case 'Z':
                    //? 2번 사물함 안의 메모지는 여전히 "내 왼쪽은 1번, 오른쪽은 3번"을 기억하고 있음
                    // 삭제한 행을 다시 복구하는데, 위의 'C'에서 사용한 k가 z로만 변경된 것에 불과
                    int z = s.pop();
                    isDeleted[z] = false;
                    // "이제 3번 말고 2번과 연결해"!가 실행되기 위해서는 복구한 2번을 그대로 연결만 하면 됨
                    if (prev[z] != -1) {
                        next[prev[z]] = z; // z가 복구한 숫자
                    }
                    if (next[z] != -1) {
                        prev[next[z]] = z; // 마찬가지
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