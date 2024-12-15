#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map> // 딕셔너리 대용
// #include <iostream>
using namespace std;

int solution(vector<int> array)
{
    unordered_map<int, int> memo;

    // 배열의 요소를 순회하면서 <K, V>를 저장
    for(auto& num: array) {
        memo[num]++; // dict.get(key, 0) + 1와 비슷하게 동작
    }   
    
    // 최댓값 계산
    int max_count = 0;
    for (const auto& pair: memo) {
        max_count = max(max_count, pair.second); // value의 최댓값을 저장
    }

    // 최빈값 추출
    int result_count = 0, mode = -1;

    for (const auto& pair: memo) {
        if (pair.second == max_count) {
            result_count++;
            mode = pair.first;
        }
    }
    // 최빈값이 여러 개인지 판단
    return (result_count > 1) ? -1 : mode;
}