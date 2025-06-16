import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]); // 중복이 되지 않기 때문에 그대로 저장
        }
        
        // 종료 조건
        if (set.size() <= nums.length / 2) {
            return set.size();
        }
        return nums.length / 2;
    }
}