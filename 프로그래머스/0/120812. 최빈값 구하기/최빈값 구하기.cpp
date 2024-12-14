#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map> // 딕셔너리 대용
using namespace std;

int solution(vector<int> array)
{
    unordered_map<int, int> memo;

    // 배열의 요소를 카운팅 
    for(auto& num: array) {
        memo[num]++;
    }   
    
    // 최댓값 계산
    int max_count = 0;
    for (const auto& pair: memo) {
        max_count = max(max_count, pair.second); // value의 최댓값을 저장
    }

    // 최빈값 추출
    vector<int> result;

    for (const auto& pair: memo) {
        if (pair.second == max_count) {
            result.push_back(pair.first);
        }
    }

    // 최빈값이 여러 개인지 판단
    return (result.size() > 1) ? -1 : result[0];
}