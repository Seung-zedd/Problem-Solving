import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            // 키가 있으면 스킵
        }
        
        // 종류 최대 탐색
        int sort = 0;
        for (int i = 0; i < map.size(); i++) {
            if (sort == nums.length / 2) {
                break;
            }
            sort += map.get(nums[i]);

        }
        return sort;
    }
}