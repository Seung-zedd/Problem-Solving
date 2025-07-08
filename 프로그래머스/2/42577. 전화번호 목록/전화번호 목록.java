import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호 해시셋으로 초기화
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        // 접두어 생성
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