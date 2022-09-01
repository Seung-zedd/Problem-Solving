#include <iostream>
using namespace std;

 int main()
{
	short origin[6] = { 1,1,2,2,2,8 };
	short find[6];

	for (int i = 0; i < 6; i++)
	{
		cin >> find[i];
		cout << origin[i] - find[i] << " ";
	}
	return 0;
}