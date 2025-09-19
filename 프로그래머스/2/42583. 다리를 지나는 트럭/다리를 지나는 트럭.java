import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 정해진 순으로 건너야 하기 때문에 대기 큐에 트럭 배열 삽입 후 초기화
        // 1. 다리에 오르기 전
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

            // 선 제거, 후 삽입
            if (!bridgeQ.isEmpty() && time - bridgeQ.peek().entryTime == bridge_length) {
                Truck exitTruck = bridgeQ.poll();
                totalWeight -= exitTruck.tWeight;
            }

            if (!waitingQ.isEmpty() && waitingQ.peek().tWeight + totalWeight <= weight && bridgeQ.size() < bridge_length) {
                Truck curTruck = waitingQ.poll();
                curTruck.entryTime = time;

                bridgeQ.offer(curTruck);
                totalWeight += curTruck.tWeight;
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