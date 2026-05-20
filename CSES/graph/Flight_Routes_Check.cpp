// Tag: Strongly Connected Component
#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;
vector<bool> vis;

int dfs(int node){
    if(vis[node])
        return node;

    vis[node] = true;

    for(int v : adj[node]){
        int cycle_entry = dfs(v);
        if(cycle_entry != -1)
            return cycle_entry;
    }
    return -1;
}

int main(){
    int n, m;
    cin >> n >> m;

    vis.assign(n + 1, false);
    adj.resize(n + 1);

    for (int i = 1; i <= n; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
    }

    int cycle_entry = dfs(1);

    
}