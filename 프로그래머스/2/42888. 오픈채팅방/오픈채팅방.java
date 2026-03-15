import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // record를 기반으로 해시맵에 최종 닉네임을 저장한다.
        // 공백을 기준으로 command, userid, nickname인데 해시맵에는 <userid, nickname>만 저장
        Map<String, String> userMap = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");
            // ! Leave는 username까지만 있으므로, msg의 길이가 3이상일 때만 파싱하고 맵에 저장
            if (msg.length > 2) {
                String userid = msg[1];
                String nickname = msg[2];
                userMap.put(userid, nickname);
            }
        }

        // 완성된 해시맵을 기준으로 record를 순회하면서 메시지를 조립
        // 이때, "+" 연산자로 조립이 가능, 왜냐하면 해시맵의 조회는 O(1)만 걸리기 때문
        // ? Change는 리턴 메시지에 포함되지 않기 때문에 record.length와 일치하지 않아서 가변 리스트 사용
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");
            String command = msg[0];
            String userid = msg[1];

            switch (command) {
                case "Enter":
                    answer.add(userMap.get(userid) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(userMap.get(userid) + "님이 나갔습니다.");
                    break;
            }
        }

        return answer.stream().toArray(String[]::new);
    }
}