#include <iostream>
#include <algorithm>

using namespace std;
const char* NOT_FOUND = "USELESS";

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int N;
	string s;

	cin >> N;
	while (N--) {
		cin >> s;
		cout << (next_permutation(s.begin(), s.end()) ? s: NOT_FOUND) << '\n';
	}
	return 0;
}