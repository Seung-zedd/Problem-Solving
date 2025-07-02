import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        // 리뷰 테스트
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(set.size(), nums.length / 2); 
    }
}