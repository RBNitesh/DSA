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

bool isPalin(vi& arr){
    int lo = 1, hi = arr.size() - 1;
    while(lo < hi){
        if(arr[lo++] != arr[hi--]){
            return false;
        }
    }
    return true;
}

void solve(){
    int n;
    cin >> n;

    vi arr(n + 1);
    f(1, n){
        cin >> arr[i];
    }

    // for(int it  : arr){
    //     cout << it << " ";
    // }
    // cout << "\n";

    if(isPalin(arr)){
        // cout << "Palindrome" << "\n";
        cout << "YES" << "\n";
        return;
    }

    else{
        int lb = 0, rb = INT_MAX;

        int lo = 1, hi = n;
        while(lo < hi){
            // cout << arr[lo] << " " << arr[hi] << "\n";
            if(abs(arr[lo] - arr[hi]) != 2){
                cout << "NO" << "\n";
                return;
            }
            else if(arr[lo] != arr[hi]){
                lb = max(lb, min(arr[lo], arr[hi]));
                rb = min(rb, max(arr[lo], arr[hi]));
            }

            lo++;
            hi--;
        }
        if(rb - lb >= 1)
            cout << "YES" << "\n";
        else
            cout << "NO" << "\n";
    }
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
