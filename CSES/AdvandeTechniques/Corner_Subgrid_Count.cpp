#include<bits/stdc++.h>
using namespace std;
using ll = long long;

using vi = vector<int>;
using vl = vector<ll>;
using vb = vector<bool>;
using vs = vector<string>;
using vpi = vector<pair<int, int>>;
using vpl = vector<pair<ll, ll>>;
using vvi = vector<vector<int>>;
using vvl = vector<vector<ll>>;
using vvb = vector<vector<bool>>;
using vvs = vector<vector<string>>;
using vvpi = vector<vector<pair<int, int>>>;
using vvpl = vector<vector<pair<ll, ll>>>;

ll M = 1e9 + 7;
ll INF1 = INT_MAX;
ll INF2 = LLONG_MAX;

#define f(i, a, b) for (int i = a; i <= b; ++i)
#define F(i, a, b, k) for (int i = a; i <= b; i += k)
#define all(x) (x).begin(), (x).end()
#define si(x) scanf("%d", &x)

ll stringToNumericBits(const string& bitStr, int i, int j){
    ll numericBits = 0;
    for (; i <= j; ++i)
    {
        char c = bitStr[i];
        numericBits <<= 1;
        if(c == '1') ++numericBits;
    }
    return numericBits;
}

void solve(){
    // write your code here
    int n;
    cin >> n;

    ll beautifulGrids = 0;

    int m = (n + 63) / 64;
    vvl arr(n, vl(m));

    // O(n^2 * m)
    f(i, 0, n - 1){
        string bitStr;
        cin >> bitStr;

        // O(m*64)
        f(j, 0, m-1)
            arr[i][j] = stringToNumericBits(bitStr, 64 * j, min(n - 1, 64 * j + 63));

        // O(n*m)
        f(j, 0, i-1){
            ll setBits = 0;
            // count the total set-bit for all the chunks
            f(k, 0, m-1){
                setBits += __builtin_popcountll(arr[j][k] & arr[i][k]);
            }
            beautifulGrids += setBits * (setBits - 1) / 2;
        }
    }
    cout << beautifulGrids << "\n";
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}