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

// optimizes bitwise operations
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("popcnt")

vb vis;

const int MAXN = 5e4+1;
vector<bitset<MAXN>> reachable;

void dfs(int node, vvi& adj){
    if(vis[node])
        return;

    vis[node] = true;

    reachable[node].set(node);

    for(int& v : adj[node]){
        dfs(v, adj);
        reachable[node] |= reachable[v];
    }
}

void solve(){
    int n, m;
    cin >> n >> m;

    vvi adj(n + 1);
    f(i, 1, m){
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
    }

    reachable.resize(n + 1);
    vis.assign(n + 1, false);
    f(i, 1, n){
        if(!vis[i])
            dfs(i, adj);
    }

    f(i, 1, n)
        cout << reachable[i].count() << " ";
    cout << "\n";
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}