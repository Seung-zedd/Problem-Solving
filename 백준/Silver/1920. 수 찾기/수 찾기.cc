#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    /* do not use C functions of scanf, printf, getchar, etc. */
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<int> v, u;
    int m, n, a, b;

    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> a;
        v.push_back(a);
    }

    // key값의 벡터
    cin >> m;
    for (int i = 0; i < m; ++i) {
        cin >> b;
        u.push_back(b);
    }

    // 정렬
    sort(v.begin(), v.end());

    // 이진탐색
    for (auto &key: u) {
        if (binary_search(v.begin(), v.end(), key))
            cout << 1 << '\n';
        else cout << 0 << '\n';
    }
}