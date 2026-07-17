// Tag: Dijkstra
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll INF = LONG_MAX;
ll MOD = (ll)1e9 + 7;

void dijkstra(int src, int dest, int N, vector<vector<pair<int, int>>> &adj){
    vector<ll> dist(N + 1, INF); // dist[i]: minimum price to reach i starting from src
    vector<ll> ways(N + 1, 0); // ways[i]: no. of ways to reach i starting from src
    vector<int> min_edge(N + 1, INF); // minimum edge to reach i starting from  src
    vector<int> max_edge(N + 1, 0); // maximum edge to reach i starting from src

    priority_queue<pair<ll,int>, vector<pair<ll,int>>, greater<pair<ll,int>>> pq;
    pq.push({0, src});

    dist[src] = 0;
    ways[src] = 1;
    min_edge[src] = 0;
    max_edge[src] = 0;

    while(!pq.empty()){
        auto curr = pq.top();
        pq.pop();

        ll du = curr.first;
        int u = curr.second;

        if(du > dist[u])
            continue;

        for(auto &neigh : adj[u]){
            int v = neigh.first, wt = neigh.second;

            if(dist[u] + wt < dist[v]){
                dist[v] = dist[u] + wt;
                ways[v] = ways[u];
                min_edge[v] = min_edge[u] + 1;
                max_edge[v] = max_edge[u] + 1;

                pq.push({dist[u] + wt, v});
            }
            else if(dist[u] + wt == dist[v]){
                ways[v] = (ways[u] + ways[v]) % MOD;
                min_edge[v] = min(min_edge[v], min_edge[u] + 1);
                max_edge[v] = max(max_edge[v], max_edge[u] + 1);
            }
        }
    }

    cout << dist[dest] << " " << ways[dest] << " " << min_edge[dest] << " " << max_edge[dest] << "\n";
}

int main(){
    int N, M;
    cin >> N >> M;

    vector<vector<pair<int, int>>> adj(N + 1);
    for (int i = 1; i <= M; i++){
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
    }

    dijkstra(1, N, N, adj);
}