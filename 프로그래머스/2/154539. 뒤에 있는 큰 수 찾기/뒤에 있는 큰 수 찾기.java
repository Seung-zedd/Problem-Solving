import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 여기에 용사님의 '단조 스택' 통찰을 발휘하세요!
        Stack<int[]> s = new Stack<>();

        // numbers 배열 순회
        // ? numbers 배열의 인덱스가 필요한가? -> O, 왜냐하면 주식 가격 문제와 비슷하게 인덱스도 기억해야 하기 때문
        for (int i = 0; i < numbers.length; i++) {
            // 자신보다 뒤에 있는 숫자들 중 크면서 가장 가까이 있는 숫자
            // 가장 가까이 있는 숫자라는 건 크면 무조건 팝을 하라는 소리, but ex1)을 보면 3 다음에 5가 나올 때까지 계속해서 pop하기
            // 때문에 while문이 적당(단조 스택)
            while (!s.isEmpty() && s.peek()[1] < numbers[i]) {
                int[] result = s.pop();
                int idx = result[0];
                answer[idx] = numbers[i];
            }

            s.push(new int[] { i, numbers[i] });
        }

        // 뒷 큰수가 존재하지 않는 원소는 -1을 담기 위해 스택 후처리
        while (!s.isEmpty()) {
            int[] result = s.pop();
            int idx = result[0];
            answer[idx] = -1;
        }

        return answer;
    }
}