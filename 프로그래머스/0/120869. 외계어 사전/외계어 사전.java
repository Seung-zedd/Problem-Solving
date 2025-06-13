import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String temp = String.join("", spell);

        for (int i = 0; i < dic.length; i++) {
            // dic 안에서의 문자도 정렬하기 위해 char형 배열로 리턴
            char[] chars = dic[i].toCharArray(); // String -> char[]
            Arrays.sort(chars);
            dic[i] = new String(chars); // char[] -> String
        }

        // temp와 dic를 비교
        for (int i = 0; i < dic.length; i++) {
            if (temp.equals(dic[i])) {
                return 1;
            }
        }

        return 2;

    }
}