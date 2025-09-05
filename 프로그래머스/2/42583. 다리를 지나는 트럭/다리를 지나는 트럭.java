import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 대기 큐에 트럭 총 무게 삽입
        Queue<Truck> waitingQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitingQ.offer(new Truck(t, 0));
        }

        // 시뮬레이션 시작
        Queue<Truck> bridgeQ = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;

        while (!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            // 2. 다리를 건넌 후(동일한 시간에서 삽입과 삭제를 수행해야 하므로)
            if (!bridgeQ.isEmpty() && time - bridgeQ.peek().entryTime == bridge_length) {
                Truck exitTruck = bridgeQ.poll();
                totalWeight -= exitTruck.tWeight; // 다리를 완전히 건넜으면 무게 감소
            }

            // 1. 다리를 건너기 전
            if (!waitingQ.isEmpty() && waitingQ.peek().tWeight + totalWeight <= weight && bridgeQ.size() < bridge_length) {
                Truck entryTruck = waitingQ.poll();
                entryTruck.entryTime = time; // 흘러간 시간을 트럭의 진입 시간으로 설정
                bridgeQ.offer(entryTruck);
                totalWeight += entryTruck.tWeight; // 다리에 진입한 트럭의 무게를 더함
            }
        }

        return time;
    }

    private static class Truck {
        int tWeight;
        int entryTime;

        public Truck(int tWeight, int entryTime) {
            this.tWeight = tWeight;
            this.entryTime = entryTime;
        }

    }
}