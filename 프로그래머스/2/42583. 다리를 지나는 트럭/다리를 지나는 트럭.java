import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitingQ = new LinkedList<>();

        // 대기 큐에 트럭들 삽입
        for (int t : truck_weights) {
            waitingQ.offer(new Truck(t, 0));
        }

        // 다리 큐
        Queue<Truck> bridgeQ = new LinkedList<>();
        int totalTruckWeight = 0;

        // 시뮬레이션 시작
        // 종료조건: 대기큐에 트럭이 없고 && 다리큐에 트럭이 없을 때
        int time = 0;
        while (!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            // Settle And Act(선 제거, 후 삽입)
            if (!bridgeQ.isEmpty() && time - bridgeQ.peek().entryTime == bridge_length) {
                Truck exitTruck = bridgeQ.poll();
                totalTruckWeight -= exitTruck.weight;
            }

            // 다리에 진입할 때
            // 다리의 무게와 길이를 고려
            if (!waitingQ.isEmpty() &&  waitingQ.peek().weight + totalTruckWeight <= weight && bridgeQ.size() < bridge_length) {
                Truck entryTruck = waitingQ.poll();
                bridgeQ.offer(new Truck(entryTruck.weight, time));
                totalTruckWeight += entryTruck.weight;
            }
        }

        return time;
    }

    private static class Truck {
        int weight;
        int entryTime;

        public Truck(int weight, int entryTime) {
            this.weight = weight;
            this.entryTime = entryTime;
        }
    }
}