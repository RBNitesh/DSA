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

// bool isPalin(vi& arr){
//     int lo = 1, hi = arr.size() - 1;
//     while(lo < hi){
//         if(arr[lo++] != arr[hi--]){
//             return false;
//         }
//     }
//     return true;
// }

// ll helper(int i, int prev, vi& arr){
//     if(i == arr.size())
//         return 0;

//     if(i == arr.size()-1)
//         return arr[i];

//     ll ans = LLONG_MAX;

//     ans = min(ans, arr[i] + helper(i + 1, arr[i], arr));

//     if(i > 1){
//         if(arr[i] < prev && arr[i] < arr[i+1]){
//             ans = min(ans, 3 * arr[i] - prev + helper(i + 2, arr[i], arr));
//         }
//     }

//     return ans;
// }

void solve(){
    int n;
    cin >> n;

    vi arr(n + 1);
    f(1, n){
        cin >> arr[i];
    }

    for (int i = 1; i <= n; ++i){
        int pivotIdx = 0;

        for (int j = 2; j < n; ++j){
            if(arr[j] < min(arr[j-1], arr[j+1])){
                if(arr[j] > arr[pivotIdx])
                    pivotIdx = j;
            }
        }

        if(pivotIdx == 0)
            break;

        arr[pivotIdx - 1] = arr[pivotIdx];
        arr[pivotIdx + 1] = arr[pivotIdx];
    }

    ll sum = accumulate(arr.begin(), arr.end(), 0L);

    // ll res = helper(1, 0, arr);
    cout << sum << "\n";
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t;
    cin >> t;
    while(t-- > 0){
		solve();
	}
}
