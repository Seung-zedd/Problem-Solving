import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별 재생횟수를 정렬하기 위한 map
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.merge(genres[i], plays[i], Integer::sum);
        }

        // 재생횟수를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(map.entrySet());

        sortedGenres.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 장르 내 재생횟수를 정렬하기 위한 mapMusic
        // {key: genres, value: play, index}
        // 객체를 저장해야 하기 때문에 computeIfAbsent()
        // 장르 내 재생횟수가 다르기 때문에 리스트를 value로 설정
        Map<String, List<Music>> mapMusic = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            mapMusic.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(plays[i], i));
        }

        // 노래의 고유번호를 저장하기 위한 리스트
        List<Integer> answer = new ArrayList<>();

        // genres[i]를 이용해서 sortedGenres -> mapMusic 전환
        for (Map.Entry<String, Integer> e : sortedGenres) {
            String key = e.getKey();
            List<Music> musicList = mapMusic.get(key);

            // 장르 내 재생횟수 내림차순 정렬(if 재생횟수 same: 인덱스 오름차순)
            musicList.sort((m1, m2) ->
            {
                if (m1.play == m2.play) {
                    return Integer.compare(m1.index, m2.index);
                } else {
                    return Integer.compare(m2.play, m1.play);
                }
            });

            for (int i = 0; i < Math.min(musicList.size(), 2); i++) {
                answer.add(musicList.get(i).index);
            }
        }

        // Integer -> int
        return answer.stream().mapToInt(i -> i).toArray();

    }

    private static class Music {
        int play;
        int index;

        public Music(int play, int index) {
            this.play = play;
            this.index = index;
        }
    }
}