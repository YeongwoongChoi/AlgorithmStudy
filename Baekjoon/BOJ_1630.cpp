/*
BOJ 1630(오민식)

1 <= x <= N을 만족하는 모든 자연수 x에 의해 나눠질 때 최소의 값 == GCD{1, 2, ..., N} (x == 1일때 예외처리)

100만 이하의 모든 x에 대해 에라토스테네스 체 전처리 후 소인수분해 이용
*/

#include <iostream>
#include <cstring>
#include <vector>

using namespace std;
using ll = long long;
bool* isPrime;

constexpr ll MOD = 987654321LL;

void setPrimes(const int& n) {
	for (int i = 2; i * i <= n; ++i) {
		if (isPrime[i]) {
			for (int j = i * i; j <= n; j += i)
				isPrime[j] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	ll res = 1LL;

	if (n == 1) {
		cout << res;
		return 0;
	}

	isPrime = new bool[n + 1];
	memset(isPrime, true, sizeof(bool) * (n + 1));

	isPrime[0] = isPrime[1] = false;
	setPrimes(n);

	vector<int> v;
	v.emplace_back(2);
	for (int i = 3; i <= n; i += 2) {
		if (isPrime[i])
			v.emplace_back(i);
	}

	for (const int& p : v) {
		ll x = p;
		while (x * p <= n)
			x *= p;
		res = (res * x) % MOD;
	}
	cout << res;
	delete[] isPrime;
	return 0;
}
