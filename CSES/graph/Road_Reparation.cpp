// Tag: Minimum Spanning Tree
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int, int>>> adj(n + 1);

    for (int i = 1; i <= m; i++){
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    // Prims's Algo
    vector<bool> vis(n + 1, false);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push({0, 1});

    ll cost = 0;
    int cnt = 0;

    while(!pq.empty()){
        auto curr = pq.top();
        pq.pop();

        int u = curr.second;
        int curr_cost = curr.first;

        if(vis[u])
            continue;

        vis[u] = true;
        cnt++;
        cost += curr_cost;

        for(auto neigh : adj[u]){
            int v = neigh.first;
            int w = neigh.second;

            if(!vis[v]){
                pq.push({w, v});
            }
        }
    }

    if(cnt == n){
        cout << cost << "\n";
    }
    else{
        cout << "IMPOSSIBLE" << "\n";
    }
}