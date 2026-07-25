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

const int MAXN = 5e4+1;
vector<bitset<MAXN>> reachable;

vvi adj, reAdj, dag, nodesInComponent;
vi vec, comp;
vb vis;

void dfs3(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int u : nodesInComponent[node])
        reachable[node].set(u);

    for(int v : dag[node]){
        dfs3(v);
        reachable[node] |= reachable[v];
    } 
}

void dfs2(int node, int c){
    if(comp[node])
        return;

    comp[node] = c;

    for(int v : reAdj[node])
        dfs2(v, c);
}

void dfs1(int node){
    if(vis[node])
        return;
    vis[node] = true;
    for(int v : adj[node])
        dfs1(v);

    vec.push_back(node);
}

int kosaraju(int n){
    vec.reserve(n); // maximum no. of nodes that stack can have is n
    vis.assign(n + 1, false);
    f(i, 1, n)
        if(!vis[i])
            dfs1(i);

    comp.assign(n + 1, 0);
    int c = 0;
    while(!vec.empty()){
        int top = vec.back();
        vec.pop_back();

        if(!comp[top])
            dfs2(top, ++c);
    }
    return c;
}

void solve(){
    int n, m, q;
    cin >> n >> m >> q;

    adj.resize(n + 1);
    reAdj.resize(n + 1);
    f(i, 1, m){
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
        reAdj[b].push_back(a);
    }

    int c = kosaraju(n); // it returns no. of scc

    nodesInComponent.resize(c + 1);
    f(i, 1, n)
        nodesInComponent[comp[i]].push_back(i);

    dag.resize(c + 1);
    f(i, 1, n){
        int u = i;
        for(int v : adj[u])
            if(comp[u] != comp[v])
                dag[comp[u]].push_back(comp[v]);
    }

    vis.assign(c + 1, false);
    reachable.resize(c + 1);
    f(i, 1, c){
        if (!vis[i])
            dfs3(i);
    }

    f(i, 1, q){
        int a, b;
        cin >> a >> b;

        if(reachable[comp[a]].test(b))
            cout << "YES" << "\n";
        else
            cout << "NO" << "\n";
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}