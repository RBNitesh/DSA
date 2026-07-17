#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll INF = LONG_MAX;

// bellman ford to find the negative cycle

int main(){
    int N, M;
    cin >> N >> M;

    vector<vector<pair<int,int>>> adj(N + 1);

    for (int i = 1; i <= M; i++){
        int u, v, w;
        cin >> u >> v >> w;

        adj[u].push_back({v, w});
    }

    // Suppose an imaginary node 0 and connects that node to 
    // every other node using zero weight edge
    vector<ll> dist(N + 1, 0);

    vector<int> parent(N + 1, 0);
    parent[0] = -1;

    for (int i = 1; i <= N; i++){ // 0 is connected to all nodes 
        parent[i] = 0; 
    }

    int unstableNode = -1;
    for (int k = 1; k <= N + 1; k++)
    { // total nodes are N+1 including imaginary node '0'
        for (int u = 1; u <= N; u++)
        {
            for (auto neigh : adj[u])
            {
                int v = neigh.first;
                int wt = neigh.second;

                if (dist[u] + wt < dist[v])
                {
                    parent[v] = u; // store the parent

                    if (k == N + 1)
                    {
                        unstableNode = v;
                        break;
                    }
                    
                    dist[v] = dist[u] + wt;
                }
            }
            if(unstableNode != -1)
                break;
        }
    }

    if(unstableNode == -1){
        cout << "NO" << "\n";
    }
    else{
        cout << "YES" << "\n";

        int cycleNode = unstableNode;

        // a simple path in a graph of N nodes can have at most N-1 edges, 
        // walking back N times guarantees that cycleNode have entered the negative cycle.
        for (int i = 1; i <= N; i++){
            cycleNode = parent[cycleNode];
        }

        vector<int> path;
        int curr = cycleNode;

        do{
            path.push_back(curr);
            curr = parent[curr];
        } 
        while (curr != cycleNode);

        path.push_back(cycleNode);

        reverse(path.begin(), path.end());

        for (size_t i = 0; i < path.size(); i++){
            if(i > 0)
                cout << " ";
            cout << path[i];
        }
        cout << "\n";
    }
}