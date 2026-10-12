#include<bits/stdc++.h>
using namespace std;
using ll = long long;

#define SZ 200005

int n, q, s, x;
int timer;
int start[SZ];
int endd[SZ];
int value[SZ];
ll bit[SZ];
vector<int> adj[SZ];

void update(int i, int delta){
    for (; i <= n; i += i&-i)
        bit[i] += delta;
}

ll query(int i){
    ll sum = 0;
    for (; i > 0; i -= i&-i)
        sum += bit[i];

    return sum;
}

void dfs(int node, int parent){
    start[node] = ++timer;
    for(int v : adj[node]){
        if(v != parent)
        dfs(v, node);
    }
    endd[node] = timer;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> q;

    for (int i = 1; i <= n; ++i){
        cin >> value[i];
    }

    for (int i = 1; i < n; ++i){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, 0);

    for (int i = 1; i <= n; ++i){
        update(start[i], value[i]);
    }

    int type;
    while (q-- > 0)
    {
        cin >> type;

        if(type == 1){
            cin >> s >> x;
            int delta = x - value[s];
            update(start[s], delta);
            value[s] = x;
        }
        else{
            cin >> s;
            cout << (query(endd[s]) - query(start[s] - 1)) << "\n";
        }
    }
}