#include<bits/stdc++.h>
using namespace std;
using ll = long long;

using vi = vector<int>;
using vl = vector<ll>;
using vpi = vector<pair<int, int>>;
using vpl = vector<pair<ll, ll>>;
using vvi = vector<vector<int>>;
using vvl = vector<vector<ll>>;
using vvpi = vector<vector<pair<int, int>>>;
using vvpl = vector<vector<pair<ll, ll>>>;

ll M = 1e9 + 7;
ll INF1 = INT_MAX;
ll INF2 = LLONG_MAX;

#define f(a, b) for (int i = a; i <= b; ++i)
#define F(a, b, k) for (int i = a; i <= b; i += k)
#define sort(a) sort(begin(a), end(a))

#define si(x) scanf("%d", &x);

ll exponent(ll base, ll pow){
	// cout << base << " " << pow << "\n";
	ll result = 1;
	while(pow > 0){
		if(pow&1)
			result = result * base % M;
		base = base * base % M;
		pow >>= 1;
	}
	// cout << "res= " << result << "\n";
	return result;
}

ll nCr(int n, int r){
	if(n < r || n < 0 || r < 0)
		return 0;
	ll num = 1, den = 1;
	for(int i = 1; i <= r; ++i){
		num = num * (n - i + 1) % M;
		den = den * i % M;
	}
	return num * exponent(den, M - 2) % M;
}

void solve(){
	int k;
	cin >> k;

	long ans;
	int n = 0;
	for (int i = 1; i <= k; ++i){
		int k;
		cin >> k;

		n += k;

		if(i == 1)
			ans = 1;
		else
			ans = ans * nCr(n - 1, k - 1) % M;
	}
	cout << ans << "\n";
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t = 1;
	// si(t)
	while(t-- > 0){
		solve();
	}
}
