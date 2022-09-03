#include <iostream>

using namespace std;

int main()
{
	//첫째 줄에 정수의 개수 N
	//-1,000,000<=N<=1,000,000:최댓값, 최솟값 설정
	int n;
	cin >> n;

	int max = -1000000;
	int min = 1000000;
	int* arr = new int[n]; //int형 포인터 변수를 배열처럼 취급, int형 메모리를 찾아줘
	for (int i = 0; i < n; i++)
	{
		cin >> *arr; //arr의 값을 n개만큼 입력

		if (*arr > max) max = *arr;
		if (*arr < min) min = *arr;
	}

	cout << min << " " << max;

	delete[] arr; // 사용한 메모리 환수
	return 0;
}
