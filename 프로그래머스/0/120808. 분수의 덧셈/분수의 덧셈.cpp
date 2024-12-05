#include <string>
#include <vector>
#include <functional>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2)
{
    vector<int> answer;

    // 두 분수를 더한다
    int r1 = (numer1 * denom2) + (numer2 * denom1); // 분자
    int r2 = denom1 * denom2;                       // 분모

    // Definition of GCD function(implemented by recursion)
    // 특정 변수 gcd을 참조값으로 전달해서 재귀 호출 구현
    function<int(int, int)> gcd = [&gcd](int a, int b) -> int
    {
        return (b == 0) ? a : gcd(b, a % b);
    };

    // gcd 함수 호출
    int gcd_result = gcd(r1, r2); // 재귀 호출

    answer.push_back(r1 / gcd_result); // 분자
    answer.push_back(r2 / gcd_result); // 분모

    return answer;
}