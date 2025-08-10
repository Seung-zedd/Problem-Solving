import java.util.*;


class Solution {
    public int solution(int n) {
        int[] table = new int[1000001];

        // base case
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            table[i] = (table[i - 1] + table[i - 2]) % 1234567;
        }
        return table[n];
     }
}