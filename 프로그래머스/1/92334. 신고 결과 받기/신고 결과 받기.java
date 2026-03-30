import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        // 1.2. 한 유저를 여러 번 신고할 수도 있지만, **동일한 유저에 대한 신고 횟수는 1회로 처리**됩니다.
        Map<String, Set<String>> reportMap = new HashMap<>();

        // 1. 신고자 -> 신고 받은 해시맵을 먼저 집계
        // report의 원소는 "이용자id 신고한id"형태의 문자열입니다.
        for (String r : report) {
            String[] msg = r.split(" ");
            String userId = msg[0];
            String reportId = msg[1];
            reportMap.computeIfAbsent(userId, key -> new HashSet<>()).add(reportId);
        }

        // 2. k번 이상 신고된 유저를 계산
        // O(N + K): 분할 및 소집
        Map<String, Integer> countMap = new HashMap<>();
        for (Set<String> reportSet : reportMap.values()) {
            for (String r : reportSet) {
                countMap.merge(r, 1, Integer::sum);
            }
        }

        // 3. k번 이상 신고된 유저가 있으면 신고자한테 정지 메일 발송
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            // 내가 누구를 신고했지?
            Set<String> reportSet = reportMap.get(userId);
            // 신고를 안 한 사람이 있을 수도 있으므로
            if (reportSet != null) {
                for (String r : reportSet) {
                    if (countMap.get(r) >= k) {
                        ans[i]++;
                    }
                }
            }
        }

        return ans;
    }
}