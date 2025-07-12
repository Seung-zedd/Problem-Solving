import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 대기 큐 초기화
        Queue<Truck> waitingQ = new LinkedList<>();
        // 트럭 무게를 대기 큐에 삽입
        for (int w : truck_weights) {
            waitingQ.offer(new Truck(w, 0)); // 아직 다리에 진입하지 않았으므로 0으로 초기화
        }

        // 다리 큐 초기화
        // 다리 길이 및 무게 비교하기 위함
        Queue<Truck> bridgeQ = new LinkedList<>();
        int time = 0; // 시뮬레이션을 위한 전체 시간
        int totalWeightOnBridge = 0; // 다리 위의 트럭 무게 합산


        // 대기 큐와 다리 큐가 비어있지 않을 때까지 시뮬레이션 실행
        while (!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;
            // 정산 후 행동, 즉 선 제거 후 삽입을 구현한다
            // 동일한 시간에서 하나의 행동을 완수해야 하기 때문에 while문 대신 if문으로 구현
            if(!bridgeQ.isEmpty()) {
                // 현재 시간 - 트럭의 진입시간 == 다리 길이 => 다리를 다 건넜음
                if (time - bridgeQ.peek().entryTime == bridge_length) {
                    Truck rearTruck = bridgeQ.poll();
                    totalWeightOnBridge -= rearTruck.truckWeight;
                }
            }


            // 후 삽입
            // 위와 동문
            if (!waitingQ.isEmpty()) {
                // 진입하기 전의 트럭 무게 + 총 트럭의 무게 <= 다리 무게면 진입 허용
                if (waitingQ.peek().truckWeight + totalWeightOnBridge <= weight && bridgeQ.size() < bridge_length) {
                    Truck frontTruck = waitingQ.poll();
                    frontTruck.entryTime = time;
                    bridgeQ.offer(new Truck(frontTruck.truckWeight, frontTruck.entryTime));
                    totalWeightOnBridge += frontTruck.truckWeight; // 다리에 진입했으므로 무게를 합산
                }
            }
        }

        return time;
    }

    private static class Truck {
        int truckWeight;
        int entryTime;

        public Truck(int truckWeight, int entryTime) {
            this.truckWeight = truckWeight;
            this.entryTime = entryTime;
        }
    }


}