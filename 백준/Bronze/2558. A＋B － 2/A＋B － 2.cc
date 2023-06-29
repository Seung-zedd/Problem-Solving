#include <iostream>
#include <cassert>
using namespace std;

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int a = 0, b = 0;

	cin >> a >> b;

	assert(a > 0 && a < 10);
	assert(b > 0 && b < 10);

	cout << a + b << endl;

	return 0;
}