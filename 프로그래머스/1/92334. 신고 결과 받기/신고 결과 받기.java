import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. report를 순회하면서 신고
        // <String, Set<String>>
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String r : report) {
            String[] msg = r.split(" ");
            String userId = msg[0];
            String reportedId = msg[1];

            reportMap.computeIfAbsent(userId, u -> new HashSet<>()).add(reportedId);
        }

        // 2. k번 이상 신고된 유저를 계산
        // reportMap의 Value를 순회하면서 신고당한 유저 카운팅
        // 시간복잡도: O(N + K), 합연산인 이유는 set의 총합인 K를 분할 및 소집하기 때문
        Map<String, Integer> countMap = new HashMap<>();
        for (Set<String> reportSet : reportMap.values()) {
            for (String r : reportSet) {
                countMap.merge(r, 1, Integer::sum);
            }
        }

        // 3. 정지 메일 발송
        // 주체: userId
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];

            // userId한테 메일을 발송하기 위함
            Set<String> reportSet = reportMap.get(userId);

            // 누가 k번 이상을 받았을까요?
            //! "neo" 없음 없음와 같이 신고한 유저가 없을 수도 있음!
            if (reportSet != null) {
                for (String r : reportSet) {
                    // k번 이상 신고 당하면
                    if (countMap.get(r) >= k) {
                        answer[i]++; // userId가 있는 인덱스에 메일 발송
                    }
                }
            }
        }
        
        return answer;
    }
}