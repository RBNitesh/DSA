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

vvi adj, reAdj, nodesInComp, dag;
vb vis;
vi comp, vec;

const int MAXN = 50001;
vector<bitset<MAXN>> reachable;

// Computes the reachability bitmask for each SCC in the condensation graph.
void dfs3(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int u : nodesInComp[node])
        reachable[node].set(u);

    for(int v : dag[node]){
        dfs3(v);
        reachable[node] |= reachable[v];
    }
}

// Assigns vertices to their respective Strongly Connected Component (SCC) using the reverse graph.
void dfs2(int node, int c){
    if(comp[node] != -1)
        return;

    comp[node] = c;

    for(int v : reAdj[node])
        dfs2(v, c);
}

// Post-order traversal to compute vertex finishing times (simulates topological sort of SCCs).
void dfs1(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int v : adj[node])
        dfs1(v);

    vec.push_back(node);
}

int kosaraju(int n){
    vis.assign(n + 1, false);
    vec.reserve(n);

    f(i, 1, n)
        if (!vis[i])
            dfs1(i);
    
    comp.assign(n + 1, -1);
    int c = 0;
    while(!vec.empty()){
        int curr = vec.back();
        vec.pop_back();

        if(comp[curr] == -1)
            dfs2(curr, ++c);
    }
    return c;
}

void solve(){
    int n, m, q;
    cin >> n >> m >> q;

    adj.resize(n + 1);
    reAdj.resize(n + 1); // Build the reverse graph. It is used in kosaraju to find the scc.

    while(m-- > 0){
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
        reAdj[b].push_back(a);
    }

    int c = kosaraju(n); // Returns the total number of strongly connected components.

    nodesInComp.resize(c + 1); // nodesInComp[u]: It stores all the nodes in component u.
    f(u, 1, n)
        nodesInComp[comp[u]].push_back(u); 

    // Build a dag(directed acyclic graph) by compressing each component as a single node
    dag.resize(c + 1); 
    f(u, 1, n)
        for(int v : adj[u])
            if(comp[u] != comp[v]) 
                dag[comp[u]].push_back(comp[v]);

    // reachable[i]: It stores the information about the nodes that can be visited from component i
    reachable.resize(c + 1); 
    vis.assign(c + 1, false); // re-assign the visited array to use for dag
    f(u, 1, c) 
        if (!vis[u])
            dfs3(u); // run a dfs for the dag

    while(q-- > 0){
        int a, b;
        cin >> a >> b;

        if(reachable[comp[a]].test(b)) // check if there is a path from comp[a] to node b
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