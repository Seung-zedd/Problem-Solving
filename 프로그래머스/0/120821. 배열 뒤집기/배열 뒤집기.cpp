#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> num_list)
{
    reverse(begin(num_list), end(num_list));
    return num_list;
}