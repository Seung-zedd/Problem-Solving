#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    if (n % 7 != 0)
        return int(n / 7) + 1;
    else
        return int(n / 7);
}