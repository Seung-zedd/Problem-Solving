import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 1. 초기 데이터 스트림 생성: genres, plays, index를 합쳐 Music 객체 스트림으로 변환
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))

                // 2. 장르 별 그룹핑
                // Map<String, List<Music>> 생성
                .collect(Collectors.groupingBy(Music::getGenre))

                // 3. 그룹핑된 Map을 다시 스트림으로 변환하여 장르 별 정렬 준비
                .entrySet().stream()

                // 4. 장르 정렬 (ORDER BY SUM(plays) DESC)
                // 각 장르(entry)의 총 재생 횟수를 계산해서 내림차순으로 정렬
                .sorted((e1, e2) -> Integer.compare(
                        e2.getValue().stream().mapToInt(Music::getPlay).sum(),
                        e1.getValue().stream().mapToInt(Music::getPlay).sum()
                ))

                // 5. 각 장르 내에서 노래 정렬 후, 상위 2곡 추출하고 하나의 스트림으로 합치기
                .flatMap(e -> e.getValue().stream()

                        // 5-1. 장르 내 노래 정렬 (ORDER BY playCount DESC, index ASC)
                        .sorted(Comparator.comparing(Music::getPlay).reversed().thenComparing(Music::getIndex))
                        // 5-2. 상위 2개 선택 (LIMIT 2)
                        .limit(2)
                )

                // 6. 최종 결과에서 노래의 고유 변호(index)만 추출
                .mapToInt(Music::getIndex)
                // 7. int 배열로 변환하여 변환
                .toArray();

    }


    private static class Music {
        String genre;
        int play;
        int index;

        public Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        // 스트림에서 사용하기 편하도록 getter 함수 생성

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        public int getIndex() {
            return index;
        }
    }
}