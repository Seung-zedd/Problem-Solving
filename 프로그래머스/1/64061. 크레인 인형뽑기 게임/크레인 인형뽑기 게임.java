import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 1. 바구니(스택) 초기화
        Stack<Integer> s = new Stack<>();
        int r = board.length;
        int c = board[0].length;

        // 2. 크레인을 먼저 움직임
        // moves의 원소가 크레인의 위치를 의미하므로 for-each문으로 순회
        int answer = 0;
        for (int m : moves) {
            // row를 순회
            for (int i = 0; i < r; i++) {
                if (board[i][m - 1] == 0) {
                    continue;
                } else {
                    s.push(board[i][m - 1]);
                    // 같은 원소의 값이 존재하는지 검증
                    answer += AfterExploding(s);
                    board[i][m - 1] = 0; // 인형 꺼냄
                    break; // moves는 1번만 움직이기 때문
                }
            }
        }

        return answer;
    }

    private static int AfterExploding(Stack<Integer> s) {
        // stack의 top 이전 원소와 현재 들어가고 있는 값을 비교
        if (!s.isEmpty() && (s.size() > 1 && (s.get(s.size() - 2) == s.peek()))) {
            // 2개를 터뜨림
            s.pop();
            s.pop();

            return 2;
        }

        return 0;
    }
}