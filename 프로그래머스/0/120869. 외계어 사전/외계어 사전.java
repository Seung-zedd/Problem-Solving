import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // spell 정렬 후 dic와 매칭하기 위해 조합
        Arrays.sort(spell);
        String temp = String.join("", spell);


        // dic 내부의 알파벳을 정렬
        for (int i = 0; i < dic.length; i++) {
            char[] chars = dic[i].toCharArray();
            Arrays.sort(chars);
            dic[i] = new String(chars);
        }

        for (int i = 0; i < dic.length; i++) {
            if (temp.equals(dic[i])) {
                return 1;
            }
        }

        return 2;
    }
}