class Solution {
    public int[] solution(int n, long left, long right) {
        // 1) 1차원 배열의 크기를 미리 초기화
        int len = (int)(right - left) + 1;
        int[] arr = new int[len];

        // 2) left ~ right 사이를 움직이는 인덱스를 k라고 하자.
        for (int i = 0; i < len; i++) {
            long k = left + i; // 파라미터로 주어진 left, right가 long 타입이기 때문에 움직이고자 하는 인덱스 k도 long 타입으로 초기화해야함
            // 조건1 1 ≤ n ≤ 10^7과 조건2 0 ≤ left ≤ right < n^2를 조합하면 인덱스 최대치인 right가 n보다는 크다는 것을 의미
            // 따라서, row, col을 구할 때는 k를 크게 잡는다.
            int row = (int)(k / n);
            int col = (int) (k % n);

            // 빈칸에 채워야하는 원소는 max(row, col) + 1 (row와 col을 배열처럼 0부터 시작한다고 했을 때)
            //! 애초에 row와 col을 0부터 시작하면 0부터 시작하는 인덱스 k를 가진 1차원 배열과 offset을 맞출 수가 있다!
            arr[i] = Math.max(row, col) + 1;
        }
        
        return arr; 
    }
}