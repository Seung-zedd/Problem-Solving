#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    
    for (int x = 1; x < n + 1; x++)
    {
        if (x % 2 != 0) 
            answer.push_back(x);
    }
    return answer;
}