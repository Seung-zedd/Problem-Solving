#include <iostream>

using namespace std;
int main()
{	//첫째 줄에 정수의 개수 N을 입력
	int N;
	cin >> N;

	int max = -1000001;
	int min = 1000001;//-1000000<=N<=1000000
	//둘째 줄은 for문으로 돌려서 배열 입력
	int arr[1000000]; //배열 크기 선언
	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
		if (arr[i] > max) max = arr[i];//arr의 최댓값을 max로 저장
		if (arr[i] < min) min = arr[i];//arr의 최솟값을 min으로 저장
		
	}
		cout << min << " " << max;
	return 0;
}