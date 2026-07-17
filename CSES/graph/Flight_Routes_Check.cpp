// Tag: Strongly Connected Component
#include<bits/stdc++.h>
using namespace std;

vector<bool> vis;

void dfs(int node, vector<vector<int>> &adj){
    if(vis[node])
        return;

    vis[node] = true;

    for(int v : adj[node])
        dfs(v, adj);
}

int main(){
    int n, m;
    cin >> n >> m;

    vis.assign(n + 1, false);
    vector<vector<int>> adj(n+1);
    vector<vector<int>> reverse_adj(n+1);

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        reverse_adj[v].push_back(u);
    }

    dfs(1, adj); // mark visit to all the node reachable from 

    for (int i = 2; i <= n; i++){
        // check if any node is not visited from 1
        if (!vis[i]){ 
            cout << "NO\n";
            cout << 1 << " " << i << "\n";
            return 0;
        }
    }

    
    vis.assign(n + 1, false);
    dfs(1, reverse_adj); // check if we can visit node 1 from all the node

    for (int i = 2; i <= n; i++){
        // check if there is any node from we cannot visit 1
        if(!vis[i]){ 
            cout << "NO\n";
            cout << i << " " << 1 << "\n";
            return 0;
        }
    }
    
    // if we can visit all the node from 1, and we can also visit 1 from all
    // the node then all nodes are reachable from all other nodes
    cout << "YES\n";
}