import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 해시 맵{genres, plays}
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.merge(genres[i], plays[i], Integer::sum);
        }

        // Collections 객체의 정렬은 리스트만 가능하므로, 엔트리셋을 만들고 List의 인자로 넣어서 초기화
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(map.entrySet());

        // 규칙1: map의 엔트리를 돌면서 장르 별 재싱횟수 내림차순 정렬
        // 맵의 재생횟수를 기준으로 내림차순 정렬
        //? 람다식으로 어떻게 표현하더라?
        sortedGenres.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 해시 맵{genres, List<Music>}
        // 키가 같으면 업데이트되기 때문에 List<Music>으로 설정
        Map<String, List<Music>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            // 키의 값이 존재하지 않으면 새로운 리스트를 생성하고 Music 클래스를 삽입
            //? put과 computeIfAbsent 차이점이 뭐였지?
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(plays[i], i));
        }

        // 규칙2까지 정렬한 것 중 최대 2곡씩만 담기 위함
        List<Integer> answer = new ArrayList<>();

        // 장르 별 -> 장르 내로 전환(by 공통키인 genre)
        for (Map.Entry<String, Integer> e : sortedGenres) {
            String key = e.getKey();
            // 공통키를 통해 위에서 생성한 리스트를 조회
            List<Music> musicList = musicMap.get(key);

            // 규칙2: 장르 내에서 재생횟수 내림차순 정렬
            musicList.sort((m1, m2) -> {
                // 재생횟수가 같으면 인덱스 오름차순 정렬
                //! plays로 필드값을 설정하면 파라미터 변수명과 충돌하므로 유의할 것
                if (m1.playCount == m2.playCount) {
                    return Integer.compare(m1.idx, m2.idx);
                } else {
                    return Integer.compare(m2.playCount, m1.playCount);
                }
            });

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i).idx); // 뮤직 객체의 인덱스를 answer 리스트에 삽입
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class Music {
        int playCount;
        int idx;

        public Music(int playCount, int idx) {
            this.playCount = playCount;
            this.idx = idx;
        }
    }
}