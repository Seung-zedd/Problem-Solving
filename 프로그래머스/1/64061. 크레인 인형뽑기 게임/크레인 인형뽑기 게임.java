import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;

        // 1. board의 row, col 추출
        int r = board.length;

        // 바구니 소환
        Stack<Integer> s = new Stack<>();

        // 2. 크레인 작동
        // moves[i]는 해당 board의 col이므로 고정시켜야함
        // 크레인은 한번만 작동 -> 스택에 담았으면 break로 다음 m 순회
        // 10^6 < 10^8이므로 이중 for문 가능!
        for (int m : moves) {
            for (int i = 0; i < r; i++) {
                // 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
                // moves의 길이가 1부터 시작하므로 zero-based로 맞춘다
                if (board[i][m - 1] == 0) {
                    continue;
                } else {
                    s.push(board[i][m - 1]);
                    board[i][m - 1] = 0;
                    count += afterExploding(s);
                    break;
                }
            }
        }

        return count;
    }

    private static int afterExploding(Stack<Integer> s) {
        // stack 안에서 if (stack[top - 1] == stack[top]): stack.pop()을 푸시할 때마다 검증
        if (s.size() > 1 && (s.get(s.size() - 2) == s.peek())) {
            s.pop();
            s.pop();
            return 2;
        } else {
            return 0;
        }
    }
}