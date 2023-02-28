#include <iostream>
#include <cstring>
using namespace std;

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	// C와 C++사이의 stream 동기화를 끊음
	char A[100001];
	char B[100001];

	cin >> A >> B;

	for (int i = 0; i < strlen(A); i++) // AND
	{
		if (A[i] == '1' && B[i] == '1') cout << '1';
		else cout << '0';
	}
	cout << endl;

	for (int i = 0; i < strlen(A); i++) // OR
	{
		if (A[i] == '1' || B[i] == '1') cout << '1';
		else cout << '0';
	}
	cout << endl;

	for (int i = 0; i < strlen(A); i++) // XOR(odd function)
	{
		if (A[i] !=B[i]) cout << '1';
		else cout << '0';
	}
	cout << endl;

	for (int i = 0; i < strlen(A); i++) // NOT A
	{
		if (A[i] == '1') cout << '0';
		else cout << '1';
	}
	cout << endl;

	for (int i = 0; i < strlen(A); i++) // NOT B
	{
		if (B[i] == '1') cout << '0';
		else cout << '1';
	}

	return 0;
}