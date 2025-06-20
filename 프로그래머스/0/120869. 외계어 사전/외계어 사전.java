import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // 정렬
        Arrays.sort(spell);
        String temp = String.join("", spell);

        // dic 내부 문자 정렬(String -> char[])
        //! for-each문은 값을 복사하기 때문에 수정 불가
        for (int i = 0; i < dic.length; i++) {
            char[] chars = dic[i].toCharArray();
            Arrays.sort(chars);
            dic[i] = new String(chars);
        }

        // spell과 dic 비교
        for (String s : dic) {
            if (temp.equals(s)) {
                return 1;
            }
        }

        return 2;
    }
}