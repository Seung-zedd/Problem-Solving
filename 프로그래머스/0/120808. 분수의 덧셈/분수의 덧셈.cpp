#include <string>
#include <vector>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
   vector<int> answer;

    // 두 분수를 더한다
    int r1 = (numer1 * denom2) + (numer2 * denom1); // 분자
    int r2 = denom1 * denom2;                       // 분모

    /*
    기약분수? <- GCD로 해결 가능
    기약분수가 없는 소수도 마찬가지로 gcd로 처리 가능(마지막에는 base condtiion에 걸리기 때문)
    */

    
    // Definition of GCD function(implemented by recursion)
    auto gcd = [](int a, int b, auto &gcd_ref) -> int
    {
        return (b == 0) ? a : gcd_ref(b, a % b, gcd_ref);
    };

    // gcd 함수 호출
    int gcd_result = gcd(r1, r2, gcd); // 재귀 호출

    answer.push_back(r1 / gcd_result); // 분자
    answer.push_back(r2 / gcd_result); // 분모

    return answer;
}