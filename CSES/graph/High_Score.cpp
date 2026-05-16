#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll INF = LONG_MAX;

// tag: bellman ford + dfs

void dfs(int node, vector<vector<pair<int,int>>> &adj, vector<bool> &vis){
    vis[node] = true;

    for(auto neigh : adj[node]){
        if(!vis[neigh.first]){
            dfs(neigh.first, adj, vis);
        }
    }
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int,int>>> adj(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v, w;
        cin >> u >> v >> w;

        adj[u].push_back({v, w});
    }

    queue<int> q;

    vector<ll> dist(n + 1, -INF);
    dist[1] = 0;

    // O(V*E)
    for (int k = 1; k <= n; k++){
        for (int u = 1; u <= n; u++){
            for(pair<int,int> neigh : adj[u]){
                int v = neigh.first;
                int wt = neigh.second;

                if(dist[u] != -INF && dist[u] + wt > dist[v]){
                    if(k == n){
                        // store in queue to run the dfs from these nodes to find if n can be reached from these nodes
                        q.push(v); 
                    }
                    
                    dist[v] = dist[u] + wt;
                }
            }
        }
    }

    // O(V+E)
    vector<bool> vis(n + 1);
    while(!q.empty()){
        int node = q.front();
        q.pop();

        if(!vis[node])
            dfs(node, adj, vis);

        if(vis[n])
            break;
    }

    // if there exist a positive cycle in the way to reach n starting from 1, then 
    // the scores can be increased infinitely
    if(vis[n])
        cout << -1 << "\n";
    else
        cout << dist[n] << "\n";
}