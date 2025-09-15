import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 노래 재생횟수를 집계하기 위한 맵
        Map<String, Integer> genreMap = new HashMap<>();

        // 장르와 재생횟수 길이는 같음
        for (int i = 0; i < genres.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }

        // 많이 재생된 장르를 먼저 수록하기 위해 내림차순 정렬
        //! sorted는 원본 컬렉션을 정렬해주지 않음
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());
        genreList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 장르 내에서 많이 재생된 노래를 수록
        // 고유 번호를 담아야 되서 커스텀 클래스를 사용
        //! val을 Music으로만 하면 덮어씌워지기 때문
        Map<String, List<Music>> musicMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(i, plays[i]));
        }

        // 내림차순 정렬된 genreMap에서 key를 매핑해서 장르 내 재생횟수 탐색
        //! 장르별로 2개씩 베스트 앨범에 수록에서 리턴
        List<Integer> bestAlbum = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : genreList) {
            String key = entry.getKey();
            List<Music> musicList = musicMap.get(key);

            // 정렬만 수행
            musicList.sort((m1, m2) ->
                            m1.playCount == m2.playCount ? Integer.compare(m1.idx, m2.idx) : Integer.compare(m2.playCount, m1.playCount));

            // 베스트앨범 수록
            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                bestAlbum.add(musicList.get(i).idx);
            }
        }

        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Music {
        int idx;
        int playCount;

        public Music(int idx, int playCount) {
            this.idx = idx;
            this.playCount = playCount;
        }
    }
}