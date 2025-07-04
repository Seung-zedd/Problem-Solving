import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        return Math.min(set.size(), nums.length / 2);
    }
}
