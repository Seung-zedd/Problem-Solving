import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 트럭 대기큐 삽입
        Deque<int[]> waitingQ = new ArrayDeque<>();
        for (int t : truck_weights) {
            waitingQ.offer(new int[] {t, 0});
        }

        // 시뮬레이션 시작
        int time = 0;
        int totalTruckWeight = 0; // 다리에 올라가는 트럭의 총 무게
        Deque<int[]> bridgeQ = new ArrayDeque<>();
        // 전체가 비어있으면 종료 <=> 대기큐가 비어있지 않거나 다리큐가 비어있지 않으면 진행
        while (!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            // 다리에서 내려감(버퍼가 꽉 차있으면 먼저 응용층으로 올려보내는게 맞음, 그런데 전송 알고리즘은 하나만 동작하기 때문에 나가는 것을 먼저 작성한다)
            if (!bridgeQ.isEmpty() && (time - bridgeQ.peek()[1] == bridge_length)) {
                int outTruck = bridgeQ.poll()[0];
                totalTruckWeight -= outTruck;
            }

            // 다리로 올라감(다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.)
            //! 항상 peek()을 사용하면 자동반사적으로 null-safety 프로그래밍을 하자
            if (!waitingQ.isEmpty() && (totalTruckWeight + waitingQ.peek()[0] <= weight && bridgeQ.size() < bridge_length)) {
                int[] truck = waitingQ.poll();
                int inTruck = truck[0];
                int entryTime = truck[1];
                entryTime = time;
                bridgeQ.offer(new int[] {inTruck, entryTime});
                totalTruckWeight += inTruck;
            }
        }

        return time;
    }
}