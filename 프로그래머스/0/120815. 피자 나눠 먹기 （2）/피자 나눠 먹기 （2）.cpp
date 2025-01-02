#include <string>
#include <vector>

using namespace std;

int gcd(int p, int q)
{
    if (q == 0)
        return p;
    return gcd(q, p % q);
}

int solution(int n)
{
    return n / int (gcd(n, 6));
}