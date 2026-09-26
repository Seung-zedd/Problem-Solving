#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    
     
    priority_queue<long long, vector<long long>, greater<long long>> min_pq(scoville.begin(), scoville.end());

    // 1. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 아래의 동작을 반복
    int count = 0;
    while (min_pq.top() < K)
    {
        // 2. if (min_pq.size() < 2)이면 루트 원소가 1개만 남아서 모든 음식이 K 이상 스코빌 지수가 없으므로 -1을 리턴
        // base condition
        if (min_pq.size() < 2)
        {
            return -1;
        }

        // 2.1. mixed = first + second * 2;
        long long first = min_pq.top();
        min_pq.pop();
        long long second = min_pq.top();
        min_pq.pop();
        long long mixed = first + second * 2;

        // 2.2. min_pq.push(mixed);
        min_pq.push(mixed);
        count++;
    }

    // 3. return count;
    return count;
}