#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll INF = LONG_MAX;

// MultiPairs Shortest Path
int main(){
    int n, m, q;
    cin >> n >> m >> q;

    vector<vector<ll>> dist(n + 1, vector<ll>(n + 1, INF));

    for (int i = 1; i <= m; i++){
        int u, v, w;
        cin >> u >> v >> w;

        ll minDist = min((ll)w, dist[u][v]);

        dist[u][v] = dist[v][u] = minDist;
    }

    for (int u = 1; u <= n; u++){
        dist[u][u] = 0;
    }

    // Floyd-Warshall's Algorithm
    for (int k = 1; k <= n; k++){ // O(V^3)
        for (int u = 1; u <= n; u++){
            for (int v = 1; v <= n; v++){
                // if path from u to k and k to v exists
                if(dist[u][k] != INF && dist[k][v] != INF) 
                    dist[u][v] = min(dist[u][v], dist[u][k] + dist[k][v]);
            }
        }
    }

    for (int i = 1; i <= q; i++){ // O(q)
        int src, dest;
        cin >> src >> dest;
        cout << ((dist[src][dest] == INF) ? -1 : dist[src][dest]) << "\n";
    }
}