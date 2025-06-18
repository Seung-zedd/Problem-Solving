import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 매칭
        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];

    }
}