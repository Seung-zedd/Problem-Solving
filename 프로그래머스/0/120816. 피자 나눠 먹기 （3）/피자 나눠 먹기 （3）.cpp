#include <string>
#include <vector>

using namespace std;

int solution(int slice, int n)
{
    int pizza = 0;
    pizza = int(n / slice);

    if (n % slice != 0) 
        pizza++;
    return pizza;
}