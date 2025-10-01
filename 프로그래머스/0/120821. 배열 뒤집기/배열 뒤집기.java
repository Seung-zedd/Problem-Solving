import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> numList = Arrays.stream(num_list)
                .boxed().collect(Collectors.toList());
        Collections.reverse(numList);

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}