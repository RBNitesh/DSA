#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll INF = LONG_MAX;

void dijkstra(int node, vector<set<pair<int,int>>> &adj, vector<ll> &dist){
    priority_queue<pair<ll, int>, vector<pair<ll, int>>, greater<pair<ll, int>>> pq;

    pq.push({0, node});
    dist[node] = 0;

    while(!pq.empty()){
        pair<ll, int> curr = pq.top();
        pq.pop();

        int u = curr.second;
        ll du = curr.first;

        if(dist[u] < du)
            continue;

        for(pair<int,int> neigh : adj[u]){
            int v = neigh.first;
            int wt = neigh.second;

            if(du + wt < dist[v]){
                dist[v] = du + wt;
                pq.push({du+wt, v});
            }
        }
    }
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<set<pair<int,int>>> adj(n+1);

    for (int i = 0; i < m; i++){
        int u, v, w;
        cin >> u >> v >> w;

        adj[u].insert({v, w});
    }

    vector<ll> dist(n + 1, INF);

    dijkstra(1, adj, dist);

    for (int i = 1; i <= n; i++){
        if(i > 1)
            cout << " ";
        cout << dist[i];
    }
}