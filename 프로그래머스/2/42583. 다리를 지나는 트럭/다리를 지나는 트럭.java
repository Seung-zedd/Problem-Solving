import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 큐로 트럭 초기화
        Queue<Truck> waitingQ = new LinkedList<>();
        for (int w : truck_weights) {
            waitingQ.offer(new Truck(w, 0)); // 다리 진입하기 전이므로 0초 세팅
        }

        // 다리를 지나고 있는 트럭 큐
        Queue<Truck> bridgeQ = new LinkedList<>();
        int time = 0; // 최소 몇 초가 걸리는지 파악하기 위함
        int totalWeightOnBridge = 0; // 트럭의 무게는 최소 1

        // 전체 상황: 대기 큐와 다리 큐가 모두 빌 때까지 시간을 진행한다.
        //? 종료 조건인 waitingQ.isEmpty() AND bridgeQ.isEmpty()의 여사건
        while (!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            // 1. 다리를 다 건넌 트럭을 큐에서 제거합니다.
            //? Settle and Act: 삽입 후 제거를 하면 무게가 초과가 되서 다리를 완전히 건넌 시점에 대기 중인 트럭을 다리 위로 올릴 수가 없음
            if (!bridgeQ.isEmpty()) {
                Truck frontTruck = bridgeQ.peek();
                // 다리 위에 머문 시간(= 현재 시간 (time) - 진입 시간 (entryTime))이 다리 길이와 같으면 다리를 건넜음
                if (time - frontTruck.entryTime == bridge_length) {
                    totalWeightOnBridge -= bridgeQ.poll().weight;
                }
            }

            // 2. 새로운 트럭을 다리에 올립니다.
            if (!waitingQ.isEmpty()) {
                // 검문소: 트럭과 다리 길이 및 무게 비교
                if (totalWeightOnBridge + waitingQ.peek().weight <= weight) {
                    Truck newTruck = waitingQ.poll();
                    totalWeightOnBridge += newTruck.weight;

                    // 다리에 진입하는 시간을 기록하며 큐에 추가
                    newTruck.entryTime = time;
                    bridgeQ.offer(newTruck);
                }
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