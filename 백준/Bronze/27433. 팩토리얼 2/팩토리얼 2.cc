#include <iostream>
using namespace std;

long long fun(int n)
{
  if (n == 0) return 1;
  else if (n > 0)
  {
    return fun(n-1) * n;
  }
  return 0;
}

int main()
{
    int n;
    cin >> n;
  cout << fun(n) << endl;

  return 0;
}