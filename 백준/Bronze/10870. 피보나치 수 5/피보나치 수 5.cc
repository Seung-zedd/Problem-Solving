#include <iostream>

using namespace std;
int f(int n)
{	//f(0) = 0
	//f(1) = 1
	//f(2) = f(1) + f(0) = 1
	//f(3) = f(2) + f(1) = 2
	//... f(n) = f(n-1) + f(n-2)
	if (n == 0) return 0;
	if (n == 1) return 1;
	return f(n - 1) + f(n - 2);
}

int main()
{
	int n;
	cin >> n;
	cout << f(n) << endl;
	return 0;
}