import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별 재생횟수를 위한 map
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.merge(genres[i], plays[i], Integer::sum);
        }

        // 1. 재생횟수를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(map.entrySet());
        sortedGenres.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 장르 내 재생횟수를 위한 mapMusic(장르 내 재생횟수가 다른 곡들이 있으므로 List<Music>으로 Value를 설정)
        Map<String, List<Music>> mapMusic = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            mapMusic.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(plays[i], i));
        }

        // 노래 고유번호를 담기 위한 리스트(장르 종류가 100개 미만으로 랜덤해서 정적 배열로 초기화 불가)
        List<Integer> answer = new ArrayList<>();

        // 2. 장르 내 재생횟수 내림차순 정렬(if 재생횟수 같으면 인덱스 오름차순 정렬)
        for (Map.Entry<String, Integer> e : sortedGenres) {
            String genre = e.getKey();

            List<Music> musicList = mapMusic.get(genre);
            musicList.sort((m1, m2) -> {
                if (m1.playCount == m2.playCount) {
                    return m1.index - m2.index;
                } else {
                    return m2.playCount - m1.playCount;
                }
            });

            // 3. 각 장르 별로 최대 2곡의 고유 번호를 정답 리스트에 추가
            for (int i = 0; i < Math.min(musicList.size(), 2); i++) {
                answer.add(musicList.get(i).index);
            }
            
        }

        return answer.stream().mapToInt(i -> i).toArray();

    }

    private static class Music {
        int playCount;
        int index;

        public Music(int playCount, int index) {
            this.playCount = playCount;
            this.index = index;
        }


    }

}