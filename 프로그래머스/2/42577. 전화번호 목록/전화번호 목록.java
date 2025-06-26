import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 해시 셋(전화번호 정보만 필요하므로 && 전화번호는 unique)
        Set<String> set = new HashSet<>(List.of(phone_book));

        // 접두어 만들기
        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) {
                String prefix = num.substring(0, i);

                if (set.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
        
    }
    
}