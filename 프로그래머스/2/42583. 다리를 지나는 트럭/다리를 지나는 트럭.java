import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 대기 큐
        Queue<Truck> waitingQ = new LinkedList<>();
        // 대기 큐에 대기 트럭 배열 삽입
        for (int t : truck_weights) {
            waitingQ.offer(new Truck(t, 0));
        }

        // 다리 큐
        Queue<Truck> bridgeQ = new LinkedList<>();

        // 시뮬레이션 종료 조건: 대기 큐에 트럭이 없고 && 다리 큐에 트럭이 없으면 종료
        int time = 0; // 전체 시뮬레이션 시간
        int totalTruckWeightOnBridge = 0;
        while (!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            // 다리에 올라간 후
            //* Settle And Act 적용(얘가 마지막에 있으면 시간이 흐른 후 다리에 올려야 하므로)
            if (!bridgeQ.isEmpty() && time - bridgeQ.peek().entryTime == bridge_length) {
                Truck exitTruck = bridgeQ.poll();
                totalTruckWeightOnBridge -= exitTruck.weight;
            }

            // 다리에 올리기 전
            if (!waitingQ.isEmpty() && waitingQ.peek().weight + totalTruckWeightOnBridge <= weight && bridgeQ.size() < bridge_length) {
                Truck entryTruck = waitingQ.poll();
                bridgeQ.offer(new Truck(entryTruck.weight, time));
                totalTruckWeightOnBridge += entryTruck.weight;
            }
        }

        return time;
    }

    private static class Truck {
        int weight;
        int entryTime; // 다리 진입시간

        public Truck(int weight, int entryTime) {
            this.weight = weight;
            this.entryTime = entryTime;
        }
    }
}