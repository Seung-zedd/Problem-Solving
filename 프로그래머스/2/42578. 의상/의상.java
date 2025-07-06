import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // {의상 종류, 개수}
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.merge(clothe[1], 1, Integer::sum);
        }

        // 여사건 이용: 전체 경우의 수 - 알몸
        // 엔트리 맵을 통해 의상 종류 개수 계산
        // return: 카티션 프로덕트(의상 개수 + 1) -  1
        int answer = 1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            answer *= e.getValue() + 1;
        }

        return answer - 1;
    }
}