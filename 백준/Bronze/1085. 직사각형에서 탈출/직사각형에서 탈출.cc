#include <iostream>
#include <algorithm>

using namespace std;

// 직사각형의 경계선까지
int main() {
    int x, y, w, h;
    cin >> x >> y >> w >> h;

    int s1 = min(x, y), s2 = min(w - x, h - y);
    cout << min(s1, s2) << '\n';
}