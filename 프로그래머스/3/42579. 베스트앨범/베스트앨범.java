import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        // 장르별 곡 먼저 map에 초기화
        for (int i = 0; i < genres.length; i++) {
            map.merge(genres[i], plays[i], Integer::sum);
        }

        // 장르별 내림차순 정렬
        // map 자체로는 sort()를 사용 못하기 때문에 ArrayList로 초기화한 후 sort() 사용해서 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenre = new ArrayList<>(map.entrySet());

        sortedGenre.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 장르내 수록
        //? 특정 장르 내에서 곡이 전부 다르기 때문에 List를 value로 설정
        //! if Music 객체를 그냥 value로 사용하면 값이 덮어씌워지게 됨
        Map<String, List<Music>> musicMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            //? merge()는 사칙연산에 사용되기 때문에 computeIfAbsent()로 리스트를 추가해나감
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(plays[i], i));
        }

        List<Integer> ans = new ArrayList<>();

        // 장르 곡 -> 장르 내 수록
        // 장르 곡의 key를 가져와서 장르 내 정렬 알고리즘 수행
        //? 어짜피 map과 다른 musicMap에서 get() 연산을 하기 때문에 굳이 entrySet()으로 순회하지 않아도 됨
        for (Map.Entry<String, Integer> e : sortedGenre) {
            String key = e.getKey();
            List<Music> musicList = musicMap.get(key);

            musicList.sort((m1, m2) ->
            {
                if (m1.play == m2.play) {
                    return Integer.compare(m1.idx, m2.idx);
                } else {
                    return Integer.compare(m2.play, m1.play);
                }
            });

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                ans.add(musicList.get(i).idx);
            }
        }
        
        // mapToInt()를 사용해서 Integer -> int로 언박싱
        return ans.stream().mapToInt(i -> i).toArray();
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