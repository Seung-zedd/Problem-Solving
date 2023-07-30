#include <iostream>

using namespace std;

int main() {
    int m, n, a, b;
    cin >> m >> n;
    // 행렬의 원소는 0~100
    int A[m][n];
    int B[m][n];

    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> a;
            A[i][j] = a;
        }
    }
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> b;
            B[i][j] = b;
        }
    }
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cout << A[i][j] + B[i][j] << " ";
        }
        cout << '\n';
    }
}