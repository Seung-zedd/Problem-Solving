import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르 별 내림차순 정렬
        // 1-Pass: 장르 별 노래횟수만 집계
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }

        // 2-Pass: 장르 별 (고유번호, 노래횟수)를 저장하기 위한 해시맵
        // ! 해시맵에 다시 넣으면, 기존의 0번 곡 데이터가 2번 곡 데이터로 Overwrite되기 때문에 Value는 반드시 물리적 메모리 주소를
        // 추상화한 List<int[]>를 사용해야 한다!
        Map<String, List<int[]>> musicMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] { i, plays[i] }); // idx, 노래횟수
        }

        // ? 1. HashMap은 순서가 없으므로 ArrayList로 변환하여 정렬(정렬은 순서가 있음을 전제)
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());

        // ? 2. Value 내림차순 정렬
        genreList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 2. 장르 내 재생횟수 내림차순 정렬
        // 정렬된 genreList를 가져와서 key값으로 musicMap을 가져와서 내림차순 정렬을 한다.

        // 장르 종류는 10^2개 미만이기 때문에 2중 for문 사용이 가능!(왜냐하면 1-Pass에서 중복되는 장르는 집계했기 때문)
        // 고유 번호를 담을 리스트 생성
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreList) {
            String key = entry.getKey();
            List<int[]> musicList = musicMap.get(key);
            musicList.sort((m1, m2) -> {
                // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                // ! compare 함수는 반드시 리턴값이 존재해야 한다.
                if (m1[1] == m2[1]) {
                    return Integer.compare(m1[0], m2[0]);
                } else {
                    return Integer.compare(m2[1], m1[1]);
                }
            });

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i)[0]); // idx 삽입
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}