import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            if (i + 1 < phone_book.length) {
                String prefix = phone_book[i]; // 접두어를 가장 짧은 전화번호로 설정
                String tobeCompared = phone_book[i + 1];
                if (tobeCompared.startsWith(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}