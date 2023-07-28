#include <iostream>

using namespace std;

int fact(int n) {
    if (n == 0) return 1;
    else return fact(n - 1) * n;
}

int C(int n, int k) {
    int t1, t2, t3;
    t1 = fact(n);
    t2 = fact(k);
    t3 = fact(n - k);
    return t1 / (t2 * t3);
}

int main() {
    /* do not use C functions of scanf, printf, getchar, etc. */
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    cout << C(n, k) << endl;
}