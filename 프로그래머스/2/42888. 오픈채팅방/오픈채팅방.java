import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        // 1) 최종 닉네임만 추출하기 위한 record 순회
        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");
            if (msg.length > 2) {
                String userId = msg[1];
                String nickname = msg[2];
                map.put(userId, nickname);
            }
        }

        // 명령어에 따라 메세지를 조립하기 위해 StringBuilder 객체 생성
        //! 해시맵의 get() == O(1) * "님이 들어왔습니다." == O(N) = O(N)이므로 가능하다. 여기서 해시맵의 진가가 발휘된다!
        List<String> result = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            // ! 표편집 문제와 똑같이 userId, nickname은 switch-case 문안에서 파싱할 것!(배열인덱스에러 발생 우려)
            String[] msg = record[i].split(" ");
            String command = msg[0];
            String userId = msg[1];

            // 명령어에 따라 메시지를 조립 && 닉네임은 완성된 해시맵에서 꺼내 쓴다
            switch (command) {
                case "Enter":
                    result.add(map.get(userId) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(map.get(userId) + "님이 나갔습니다.");
                    break;
            }
        }

        return result.stream().toArray(String[]::new);
    }
}