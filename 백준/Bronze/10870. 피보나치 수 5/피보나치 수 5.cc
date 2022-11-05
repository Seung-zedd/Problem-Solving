#include <iostream>

using namespace std;
//0,1,1,2,3,5,8,13...
int fib(int n)
{
	int t0 = 0, t1 = 1, i, s;
	if (n <= 1) return n;
	for (i = 2; i <= n; i++)
	{
		s = t0 + t1;
		t0 = t1;
		t1 = s;
	}
	return s;
}


int main()
{
	int n;
	cin >> n;
	cout << fib(n) << endl;
}