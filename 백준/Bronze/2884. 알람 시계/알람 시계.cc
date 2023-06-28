#include <iostream>
#include <cassert> // 주어진 조건의 시간과 분만 입력받기 위해
#include <tuple> // 2개의 값을 리턴
using namespace std;

tuple<int, int> getAlarm(int h, int m)
{
	
	if (h < 1 && m < 45) // 0시 30분
	{
		h = h - 1 + 24;
		m = (m - 45) + 60;
	}

	else if (h >= 1 && m < 45) // 10 10
	{
		h = h - 1;
		m = (m - 45) + 60;
	}

	else // 0 50
	m = m - 45;
	
	return make_tuple(h, m);
}

int main()
{	
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int h = 0, m = 0;

	cin >> h >> m;

	assert(h >= 0 && h <= 23);
	assert(m >= 0 && m <= 59);

	tuple<int, int> my_tp = getAlarm(h,m);
	cout << std::get<0>(my_tp) << " ";
	cout << std::get<1>(my_tp) << endl;
}