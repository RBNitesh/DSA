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

void solve(){
    // write your code here
    int n, k;
    cin >> n >> k;

    vs arr(n);
    f(i, 0, n - 1) cin >> arr[i];  

    vvb seen(n, vb(n, false));
    vi indices;
    indices.reserve(n);

    // pigeon-hole principle guarantee that there will be 
    // at max n*(n-1)/2 different pairs of indices for each character
    f(c, 0, k-1){
        seen.assign(n, vb(n, false));
        bool isFound = false;

        f(i, 0, n-1){
            indices.clear();

            f(j, 0, n-1){

                if(arr[i][j]-'A' != c)
                    continue;

                for(int idx : indices){
                    if(seen[j][idx]){
                        cout << "YES" << "\n";
                        isFound = true;
                        break;
                    }
                    seen[j][idx] = true;
                }

                if(isFound)
                    break;

                // push the curr index of c in the indices vector
                indices.push_back(j);

            }
            if(isFound)
                break;
        }

        if(!isFound)
            cout << "NO" << "\n";
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}