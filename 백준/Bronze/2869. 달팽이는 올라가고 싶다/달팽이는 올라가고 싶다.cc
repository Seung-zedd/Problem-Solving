#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    int A, B, V;
    cin >> A >> B >> V;
    // 반복문을 쓰면 무조건 시간초과!
    // 무조건 수학적 지식을 활용하여 O(1)로 끝내야함
    int k = (V - B) / (A - B);
    int numer = V - B;
    int denom = A - B;

    if (numer % denom == 0) cout << k << endl;
    else cout << k + 1 << endl;
}
