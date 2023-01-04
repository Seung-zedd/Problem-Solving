#include <iostream>
#include <vector>
#include <algorithm>//max_element함수 사용
using namespace std;

int main()
{
	
	vector<int> v = { 0,0,0,0,0,0,0,0,0};//0으로 size개수 알려줌
	for (int& number : v)
		cin >> number;//for-each문으로 number를 9개 입력받는다
	
	int max_value = *max_element(v.begin(), v.end());
	cout<< max_value << endl;
	//반복자는 포인터이므로 역참조를 사용
	//max는 두가지 요소를 비교, max_element는 3가지 요소 이상을 비교
	int max_ix = max_element(v.begin(), v.end()) - v.begin() + 1;
	cout << max_ix  << endl;
	// 최대값을 가리키는 반복자를 맨 처음 가리키는 v.begin()만큼 빼주면 인덱스 값 구할 수 있음
	// 자연수는 1부터 시작하므로 +1해줄 것
    
	return 0;
}