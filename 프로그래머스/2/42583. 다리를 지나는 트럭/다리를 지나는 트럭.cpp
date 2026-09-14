#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<size_t> ready_q;
    // 트럭무게, 진입시간
    queue<pair<size_t, size_t>> bridge_q;

    // 트럭들을 대기큐에 삽입
    for (auto &t : truck_weights)
    {
        ready_q.push(t);
    }

    // 시뮬레이션 시작
    int time = 0;
    int total_truck_weight = 0;

    // 종료 조건: 대기큐와 다리큐가 모두 비어있을 때 == 다리를 모두 건넜을 때 <=> 대기큐 또는 다리큐가 비어있지 않을 때
    while (!ready_q.empty() || !bridge_q.empty())
    {
        time++;
        // 1) 다리 끝에 도달한 트럭 내보내기 (경과 시간 - 진입 시간 == bridge_length)
        if (!bridge_q.empty() && (time - bridge_q.front().second == bridge_length))
        {
            size_t exit_truck_weight = bridge_q.front().first;
            bridge_q.pop();
            // 무게 감소
            total_truck_weight -= exit_truck_weight;
        }

        // 2) 새 트럭이 다리에 오를 수 있는지 검사 (다리 위 총 무게 + 새 트럭 무게 <= weight)
        if (!ready_q.empty() && (total_truck_weight + ready_q.front() <= weight) && (bridge_q.size() < bridge_length))
        {
            size_t enter_truck_weight = ready_q.front();
            ready_q.pop();
            // 무게 추가하고
            total_truck_weight += enter_truck_weight;
            // 다리큐에 추가
            size_t entry_time = time;
            bridge_q.push({enter_truck_weight, entry_time});
        }
    }

    return time;
}