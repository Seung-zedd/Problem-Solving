#include <iostream>

using namespace std;

int main()
{
	int* p;
	p = new int[100];
	int num;
	int count = 0;
	
	cin >> num;//첫째줄 입력
	if (1 <= num && num <= 100) {
		
		for (int i = 0; i < num; i++)
			cin >> p[i];//동적으로 할당한 배열크기만큼 입력을 받음
			int v;
			cin >> v;//v는 몇개?
			for (int j = 0; j < num; j++) 
				if (p[j] == v) count++;

	}
		
	cout << count << endl;
	


	return 0;
}