#include <string>
#include <vector>

using namespace std;

// DFS 헬퍼 함수
int dfs(const vector<int> &numbers, int target, int idx, int current_sum)
{
    // Base condition: 모든 숫자를 순서대로 전부 사용한 시점
    //? zero-based idx는 항상 n-1인데, 이걸 역이용해서 idx == n으로 하면 벡터 순회를 다했다는 의미
    if (idx == numbers.size())
    {
        // 끝까지 왔을 때 누적합이 target과 같다면 1가지 방법 완성, 아니면 0
        return current_sum == target ? 1 : 0;
    }

    // 그렇지 않으면 순회하면서 이벤트를 발생시킴
    // 현재 숫자에 + 이벤트를 적용한 상태
    int plus_count = dfs(numbers, target, idx + 1, current_sum + numbers[idx]);
    // 현재 숫자에 - 이벤트를 적용한 상태
    int minus_count = dfs(numbers, target, idx + 1, current_sum - numbers[idx]);

    return plus_count + minus_count;
}

int solution(vector<int> numbers, int target) {
    return dfs(numbers, target, 0, 0);
}