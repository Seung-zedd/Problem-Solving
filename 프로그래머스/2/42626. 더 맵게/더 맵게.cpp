#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    
    int count = 0;
    // 1. Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
    priority_queue<int, vector<int>, greater<int>> min_pq(scoville.begin(), scoville.end());

    // 2. 가장 덜 매운 음식(pq.top())이 K 미만인 동안 반복
    //? 2.1. mixed_scoville = scoville[0] + scoville[1] * 2;
    //? 2.2. scoville[0] = mixed_scoville; 이 2개가 while문에서 반복하다보면 루트에는 1개만 남기 때문
    while (min_pq.top() < K) 
    {
        // 엣지 케이스: 더 이상 섞을 음식이 없는데도 K에 도달하지 못한 경우
        //? 1.1 과정을 반복하다보면 마지막에는 루트 원소만 남기 때문
        if (min_pq.size() < 2)
        {
            return -1;
        }

        /* [빈칸 1]: 가장 덜 매운 첫 번째 음식과 2번째 음식 꺼내기 (first, second) & pop */
        int first = min_pq.top();
        min_pq.pop();
        int second = min_pq.top();
        min_pq.pop();
        int mixed = first + second * 2;
        min_pq.push(mixed);
        count++;
    }

    return count;

}