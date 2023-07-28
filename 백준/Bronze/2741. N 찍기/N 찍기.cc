#include <iostream>

using namespace std;

int main() {
    /* do not use C functions of scanf, printf, getchar, etc. */
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        cout << i << '\n';
    }
}