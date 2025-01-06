#include <vector>
#include <string>
#include <algorithm>
// #include <bits/stdc++.h> <- 비표준 라이브러리이므로, 다른 컴파일러와 충돌할 우려가 있으므로 사용하지 말 것!

using namespace std;

string solution(string my_string)
{
    reverse(my_string.begin(), my_string.end());
    return my_string;
}
