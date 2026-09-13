#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    
    unordered_map<size_t, size_t> map;
    for (auto &t : tangerine)
    {
        map[t]++;
    }

    // 1. 개수(second)들만 담을 벡터 준비
    vector<size_t> counts;
    for (auto &e : map)
    {
        counts.push_back(e.second);
    }

    // 개수를 기준으로 내림차순
    //? greater<size_t>()가 무슨 용도임?
    sort(counts.begin(), counts.end(), greater<size_t>());
    // 내림차순 정렬된 counts를 하나씩 꺼내면서 k개에서 차감; 이때 types도 1 추가
    int types = 0;
    for (auto &c : counts)
    {
        // 방어적 프로그래밍
        if (k <= 0)
        {
            break;
        }
        k -= c;
        types++;
    }

    return types;

}