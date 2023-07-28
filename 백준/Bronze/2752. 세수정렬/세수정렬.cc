#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    /* do not use C functions of scanf, printf, getchar, etc. */
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b, c;
    cin >> a >> b >> c;
    vector<int> v;

    v.push_back(a);
    v.push_back(b);
    v.push_back(c);
    sort(v.begin(), v.end());

    for (auto &e: v)
        cout << e << " ";
    cout << '\n';
}