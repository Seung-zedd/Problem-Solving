#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string my_string, int n)
{
    string answer = "";

    for (const auto& s : my_string)
    {
        for (int i = 0; i < n; i++)
        {
            answer += s;
        }
    }
    return answer;
}