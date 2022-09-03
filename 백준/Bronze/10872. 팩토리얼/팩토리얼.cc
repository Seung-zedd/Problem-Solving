#include <iostream>

using namespace std;
int f(int n)
{
	if (n == 0) return 1;
	return n * f(n - 1);
}

int main()
{	//1. 0! = 1
	//2. 큰 문제를 작은 문제로 쪼갠다
	
	int n;
	cin >> n;
	cout << f(n) << endl;
	return 0;
}