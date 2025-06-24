import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // {key:genre, value: playCount, genre}
        // 객체와 int는 덧셈이 불가하므로 순수하게 노래횟수만 계산
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.merge(genres[i], plays[i], Integer::sum);
        }

        // {key: genre, value: Music(playCount, index, genre} (∵그래야 장르별 노래횟수 내림차순 정렬 후에 장르 정보를 통해서 재생횟수 조회 가능)
        // 장르별로 재생횟수 계산 및 정렬하기 위함
        Map<String, List<Music>> mapMusic = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            mapMusic.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(plays[i], i, genres[i]));
        }

        // 1. 장르 선정: 총 재생 횟수가 높은 장르 순으로 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(map.entrySet());
        sortedGenres.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<Integer> answer = new ArrayList<>();
        // 2. 정렬된 장르 순서대로 순회
        for (Map.Entry<String, Integer> entry : sortedGenres) {
            String genre = entry.getKey();

            // 3. 각 장르 내에서 노래를 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
            List<Music> musicList = mapMusic.get(genre);
            musicList.sort((m1, m2) -> {
                if (m1.playCount == m2.playCount) {
                    return m1.index - m2.index; // 재생 횟수가 같으면 고유 번호 오름차순
                }
                return m2.playCount - m1.playCount; // 재생 횟수 내림차순
            });

            // 4. 각 장르별로 최대 2곡의 고유 번호를 정답 리스트에 추가
            for (int i = 0; i < Math.min(musicList.size(), 2); i++) {
                answer.add(musicList.get(i).index);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();

    }

    private static class Music {
        int playCount;
        int index;
        String genre;

        public Music(int playCount, int index, String genre) {
            this.playCount = playCount;
            this.index = index;
            this.genre = genre;
        }

    }

}