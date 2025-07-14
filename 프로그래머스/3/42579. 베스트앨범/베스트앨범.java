import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별 해시맵
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.merge(genres[i], plays[i], Integer::sum);
        }

        // 장르 별 내림차순 정렬
        // sort()를 사용하기 위해 리스트로 초기화
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(map.entrySet());
        sortedGenres.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 장르 내 재생횟수 내림차순 정렬하기 위해 List<Music>을 타입으로 지정
        Map<String, List<Music>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(plays[i], i));
        }

        // map -> musicMap으로 하기 위해 공통키인 sortedGenres의 key가 필요
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> e : sortedGenres) {
            String key = e.getKey();
            List<Music> musicList = musicMap.get(key);
            musicList.sort((m1, m2) ->
            {
                // 재생횟수가 같으면 고유 번호 오름차순
                if (m1.play == m2.play) {
                    return Integer.compare(m1.idx, m2.idx);
                } else {
                    // 그렇지 않으면 재생횟수 내림차순
                    return Integer.compare(m2.play, m1.play);
                }
            });

            // 베스트 앨범 2곡 수록
            // 장르에 속한 곡이 하나라면, 하나의 곡만 선택하기 때문에 Math.min() 크기만큼 순회
            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i).idx);
            }
        }

        // List -> int[]
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class Music {
        int play;
        int idx;

        public Music(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }
}