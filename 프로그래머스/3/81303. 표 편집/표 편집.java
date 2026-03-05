import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 표를 Doubly-Linked List로 접근하기 위해 원시 배열로 초기화
        int[] prev = new int[n];
        int[] next = new int[n];

        // 표를 크기 n만큼 초기화(0 ~ n - 1)
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // -1로 없음을 표시
            next[i] = i + 1;
        }
        next[n - 1] = -1; // n 행은 없음

        // 스택 초기화
        Stack<Integer> s = new Stack<>();

        // 표의 상태와 처음 주어진 표의 상태를 비교하기 위한 boolean 타입의 isDeleted 배열을 표의 크기로 초기화
        boolean[] isDeleted = new boolean[n];

        // cmd 순회
        // ? 프레임워크(스택, 큐, 해시맵 등)를 읽으면서 동시에 쓰기를 진행하면 ConcurrentException이 터짐, But 컨테이너
        // 타입이 아닌 것은 상관 X
        for (String str : cmd) {
            String result = str;
            Character command = result.charAt(0); // 명령어

            switch (command) {
                case 'U':
                    // ! X가 없으면 예외가 터지기 때문에 X가 존재하는 'U' 아니면 'D'에서만 파싱을 한다
                    int x = Integer.parseInt(result.substring(2)); // 횟수
                    while (x-- > 0) {
                        k = prev[k]; // 현재 선택된 행인 k를 위로 이동(e.g. k = 2이면, prev[k]인 1을 k로 업데이트)
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(result.substring(2)); // 횟수
                    while (y-- > 0) {
                        k = next[k]; // 현재 선택된 행인 k를 위로 이동
                    }
                    break;
                case 'C':
                    // 현재 선택된 행을 '삭제'
                    s.push(k);

                    // 삭제 상태를 표시
                    isDeleted[k] = true;

                    // 다음 행으로 연결하기 위해서는 이전 행이 존재해야 한다.
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }

                    // 바로 아래 행을 선택, 단, 현재 선택된 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택
                    k = next[k] == -1 ? prev[k] : next[k];
                    break;

                case 'Z':
                    // '가장 최근에 삭제된 행'을 '원래대로 복구'
                    int z = s.pop();

                    // 삭제 상태를 복구
                    isDeleted[z] = false;

                    // ? z에 대한 연결은 이미 표를 크기 n만큼 초기화에서 연결이 되어있기 때문에 끊어진 연결만 다시 원복시켜주면 됨
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

        

        // 3. 여기서 StringBuilder를 사용함으로써 O(N^2) 방지!
        StringBuilder sb = new StringBuilder();

        // 4. isDeleted를 for문으로 순회
        for (boolean b : isDeleted) {
            // 4.1. 삭제되지 않은 행은 O == false면 "O"
            if (b == false) {
                sb.append("O");
            } else {
                // 4.2. 삭제된 행은 X == true면 "X"
                sb.append("X");
            }
        }

        // 5. return sb.toString()
        return sb.toString();
    }
}