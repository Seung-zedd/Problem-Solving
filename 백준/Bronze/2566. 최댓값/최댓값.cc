#include <iostream>

using namespace std;


int main() {
    int A[9][9], a;
    int maxValue = 0;
    int row = 0, col = 0;
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            cin >> a;
            A[i][j] = a;
            if (maxValue < A[i][j]) {
                maxValue = A[i][j];
                row = i;
                col = j;
            }
        }
    }
    cout << maxValue << '\n';
    cout << row + 1 << " " << col + 1 << '\n';
}