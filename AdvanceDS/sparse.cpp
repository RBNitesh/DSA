// video https://youtu.be/0jWeUdxrGm4
// problem https://www.spoj.com/problems/RMQSQ/
#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 100'005;
const int LOG = 17;
int a[MAX_N];
int m[MAX_N][LOG]; // m[i][j] is minimum among a[i..i+2^j-1]
int bin_log[MAX_N];

class sparse{
	public:
	sparse(vector<int> &a, int n){
		bin_log[1] = 0;
		for(int i = 2; i <= n; i++) {
			bin_log[i] = bin_log[i/2]+1;
		}
		for(int i = 0; i < n; i++) {
			m[i][0] = a[i];
		}
		// 2. preprocessing, O(N*log(N))
		for(int k = 1; k < LOG; k++) {
			for(int i = 0; i + (1 << k) - 1 < n; i++) {
				m[i][k] = min(m[i][k-1], m[i+(1<<(k-1))][k-1]);
			}
		}
	}

	int query(int L, int R) { // O(1)
		int length = R - L + 1;
		int k = bin_log[length];
		return min(m[L][k], m[R-(1<<k)+1][k]);
	}
};

int main() {
	// 1. read input
	int n;
	cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++)
		cin >> a[i];


	sparse st(a, n);


	// 3. answer queries
	int q;
	cin >> q;
	for(int i = 0; i < q; i++) {
		int L, R;
		cin >> L >> R;
		cout << st.query(L, R) << "\n";
	}
}
