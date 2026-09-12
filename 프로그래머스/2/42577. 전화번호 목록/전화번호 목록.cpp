#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

bool solution(vector<string> phone_book) {
    
    // 해시셋 생성
    unordered_set<string> set;
    // 해시셋에 전화번호 저장
    for (auto &p : phone_book)
    {
        set.insert(p);
    }

    // 한 번호가 다른 번호의 접두어
    for (auto &p : phone_book)
    {
        // 접두어 이어붙임
        for (size_t i = 1; i < p.length(); i++)
        {
            string prefix = p.substr(0, i);
            if (set.count(prefix) > 0)
            {
                return false;
            }
        }
    }

    return true;

}