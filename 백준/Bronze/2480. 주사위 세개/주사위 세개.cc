#include <iostream>
#include <cassert> // 1~6까지만 입력받음
#include <vector> // 입력받은 값을 벡터에 삽입
#include <algorithm> // max_element 사용

using namespace std;

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int a = 0, b = 0, c = 0;
	cin >> a >> b >> c;

	// a,b,c 모두 1~6까지만 입력을 받음
	assert((a >= 1 && a <= 6) && (b >= 1 && b <= 6) && (c >= 1 && c <= 6));
	
	// 같은 눈 3개 나오는 경우
	if (a == b && b == c && c == a)
	{
		int result1 = 10000 + (a * 1000);
		cout << result1 << endl;
	}
		// 같은 눈 2개 나오는 경우
		else if (a == b)
		{
			cout << 1000 + (a * 100) << endl;
		}

		else if (b == c)
		{
			cout << 1000 + (b * 100) << endl;
		}

		else if (c == a)
		{
			cout << 1000 + (c * 100) << endl;
		}

		// 모두 다른 눈이 나옴 => max value
		else if (!(a == b && b == c && c == a))
		{

			vector<int> v;

			for (int i = 0; i < 3; i++)
			{
				v.push_back(a);
				v.push_back(b);
				v.push_back(c);
			}

			int temp = *max_element(v.begin(), v.end()); // 리턴값은 포인터이므로 역참조
			cout << temp * 100 << endl;
		}
	
	return 0;
}