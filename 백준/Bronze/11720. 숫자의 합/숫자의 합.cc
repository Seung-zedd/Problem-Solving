#include <iostream>

using namespace std;

int main()
{	//1.숫자의 개수 N개를 입력받는다
	//2.string을 N개만큼 입력받는다
	//3.string의 합을 출력한다
	int n, sum = 0;
	cin >> n;
	
	char* ch = new char[n];
	cin >> ch;
	//만약 출력을 for문을 돌려서 sum으로 받는다면...?
	for (int i = 0; i < n; i++)
	{	//char*ch = {'1','2','3','4','5'};
		
		sum = sum + ch[i] - '0';
	}
	cout << sum << endl;
		
	return 0;
}