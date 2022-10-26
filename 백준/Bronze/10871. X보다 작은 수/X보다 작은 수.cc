#include <iostream>

using namespace std;

int main()
{
	int* p;
	p = new int[10000];
	int num, x = 0;
	cin >> num>>x;//배열 개수 입력
	for (int i = 0; i < num; i++)
		cin >> p[i];//배열 개수만큼 숫자 입력
	for (int j = 0; j < num; j++)
	{
		
		if (p[j] < x) cout << p[j] << " ";
	}


	return 0;
}