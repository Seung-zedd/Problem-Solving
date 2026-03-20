import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 신고 명단 작성 중...
        // reportMap의 역할: userid -> 신고한 reportid의 셋
        // ! 리스트는 reportid가 같아도 다르게 취급하기 때문에 해시셋 사용
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String r : report) {
            String[] msg = r.split(" ");
            String userid = msg[0];
            String reportid = msg[1];

            reportMap.computeIfAbsent(userid, str -> new HashSet<>()).add(reportid);
        }

        // countMap의 역할: 신고당한 reportid의 신고 횟수
        // 누가 총 몇 표를 받았는가?
        // ? 바깥루프: 2 * 10^5인데, 내부루프는 합이 2* 10^5이므로, 최종적으로 2*10^5밖에 안걸린다??
        Map<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            for (String reportid : entry.getValue()) {
                countMap.merge(reportid, 1, Integer::sum);
            }
        }

        // 처리 결과 메일
        // id_list를 순회하면서 당선됬으면 reportMap의 key한테 메일 발송
        for (int i = 0; i < id_list.length; i++) {
            String userid = id_list[i]; // 메일을 받을 후보자

            // userid가 신고한 녀석들을 먼저 추출
            Set<String> reportedSet = reportMap.get(userid);

            // 실제로 정지된 유저가 몇 명?
            // ! "neo" 없음 없음과 같이 신고를 하지 않은 userid가 있을 수 있다
            if (reportedSet != null) {
                for (String r : reportedSet) {
                    // 정지 기준이 되는 횟수 k를 넘기면
                    if (countMap.get(r) >= k) {
                        answer[i]++; // 메일을 받는다
                    }
                }
            }
            
        }

        return answer;
    }
}