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

#define f(i, a, b) for (int i = a; i <= b; ++i)
#define F(i, a, b, k) for (int i = a; i <= b; i += k)
#define sort(a) sort(begin(a), end(a))

// #define si(x) scanf("%d", &x);

void solve(){
    // write your code here
    int n, k;
    cin >> n >> k;

    vi arr(n + 1);
    f(i, 1, n){
        string s;
        cin >> s;

        f(k, 0, 29){
            if(s[k] == '1')
                arr[i] += 1 << (30 - k - 1);
        }
    }

    int ans = 30;
    f(i, 1, n){
        f(j, i+1, n){
            ans = min(ans, __builtin_popcount(arr[i] ^ arr[j]));
        }
    }
    cout << ans << "\n";
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}