#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    
    (void)participant;
    (void)completion;
    // 참가자 해시맵 생성
    unordered_map<string, int> part_map;

    // 참가자 카운팅
    for (auto &p : participant)
    {
        part_map[p]++;
    }

    //! 완주자 for문 돌리면서 comp 명단에 있으면 -1
    //? "결승선으로 한 명 들어올 때마다(for (auto& c : completion)), 내가 쥐고 있는 참가자 장부(part_map)에서 그 사람의 이름을 찍찍 긋거나 숫자를 1씩 뺀다(part_map[c]--)!"
    for (auto &c : completion)
    {
        part_map[c]--;
    }

    // 참가자 value 그대로 리턴(완주하지 못한 선수는 1명이므로)
    //? key가 어떤 놈인지 모르기 때문에 for문으로 엔트리 순회
    for (auto &e : part_map)
    {
        if (e.second > 0)
        {
            return e.first;
        }
    }

    return "";

}