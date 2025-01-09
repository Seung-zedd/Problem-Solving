#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list)
{
    int even = 0, odd = 0;
    vector<int> answer;

    for(auto& num : num_list) {
        if(num % 2 == 0) {
            even += 1;
        } else {
            odd += 1;
        }
    }
    answer.push_back(even);
    answer.push_back(odd);

    return answer;
}