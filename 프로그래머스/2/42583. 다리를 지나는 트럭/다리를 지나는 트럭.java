import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 트럭 대기 큐
        Queue<Truck> readyQ = new LinkedList<>();

        for (int t : truck_weights) {
            readyQ.offer(new Truck(t, 0));
        }

        // 다리 큐
        Queue<Truck> bridgeQ = new LinkedList<>();

        // 시뮬레이션 시작
        int time = 0;
        int totalTruckWeight = 0; // 다리 무게와 비교

        // 종료 조건: 모든 트럭이 다리를 건넜을 때 == 대기큐와 다리큐가 모두 비었을 때 false가 되서 time을 리턴
        while (!readyQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;

            // 다리를 건넌 후(선 제거 따로)
            //* Settle then Act: 선 제거, 후 삽입
            //? 다리에 도착했다는 것을 어떻게 알지? -> time - entryTime == bridge_length면 bridgeQ.poll()
            if (!bridgeQ.isEmpty() && time - bridgeQ.peek().entryTime == bridge_length) {
                Truck nextTruck = bridgeQ.poll();
                totalTruckWeight -= nextTruck.weight;
            }

            // 다리를 건너기 전(후 삽입 따로)
            // 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
            //? readyQ.peek()이 null이 될 수 있으므로 안전하게 if문으로 방어
            if (!readyQ.isEmpty()) {
                // 레디 큐에서 제거하기 전에 peek()로 다리 조건 검사
                if (readyQ.peek().weight + totalTruckWeight <= weight && bridgeQ.size() <= bridge_length) {
                    // 조건이 맞으면 대기 큐에서 제거를 함으로써 변하는 totalTruckWeight에 맞춤
                    Truck curTruck = readyQ.poll();
                    curTruck.entryTime = time;
                    // 다리를 건너는 중
                    bridgeQ.offer(curTruck);
                    totalTruckWeight += curTruck.weight;
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