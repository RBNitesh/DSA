// Tag: Minimum Spanning Tree
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

class DSU{
    vector<int> parent;
    vector<int> rank;

    public:
    DSU(int V){
        parent.resize(V + 1);
        rank.assign(V + 1, 0);

        for (int i = 1; i <= V; i++){
            parent[i] = i;
        }
    }

    int find(int u){
        return parent[u] = (u == parent[u]) ? u : find(parent[u]);
    }

    void unite(int u, int v){ // union is a keyword in cpp
        int rootU = find(u), rootV = find(v);

        if(rank[rootU] <= rank[rootV]){
            parent[rootU] = rootV;

            if(rank[rootU] == rank[rootV])
                rank[rootV]++;
        }
        else{
            parent[rootV] = rootU; 
        }
    }
};

class Edge{
public:
    int u, v, w;
    Edge(int u, int v, int w){
        this->u = u; this->v = v;
        this->w = w;
    }
};

int main(){
    int n, m;
    cin >> n >> m;

    vector<Edge> edges; // used for kruskals algo
    // vector<vector<pair<int, int>>> adj(n + 1); // used for prims algo

    for (int i = 1; i <= m; i++){
        int u, v, w;
        cin >> u >> v >> w;

        edges.push_back(Edge(u, v, w));

        // adj[u].push_back({v, w});
        // adj[v].push_back({u, w});
    }

    // Kruskal's Algo
    sort(edges.begin(), edges.end(), 
        [](Edge& a, Edge& b){ 
            return a.w < b.w; 
        }
    );

    int cnt = 0;
    ll cost = 0;
    DSU dsu(n);

    for (int i = 0; i < edges.size(); i++){
        Edge curr_edge = edges[i];

        int u = curr_edge.u, v = curr_edge.v;
        int w = curr_edge.w;

        if(dsu.find(u) != dsu.find(v)){
            dsu.unite(u, v);
            cost += w;

            if(++cnt == n-1) break;
        }
    }

    if(cnt == n-1){ // no. of edge
        cout << cost << "\n";
    }
    else{
        cout << "IMPOSSIBLE" << "\n";
    }

    // Prims's Algo
    // vector<bool> vis(n + 1, false);
    // priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    // pq.push({0, 1});

    // ll cost = 0;
    // int cnt = 0;

    // while(!pq.empty()){
    //     auto curr = pq.top();
    //     pq.pop();

    //     int u = curr.second;
    //     int curr_cost = curr.first;

    //     if(vis[u])
    //         continue;

    //     vis[u] = true;
    //     cnt++;
    //     cost += curr_cost;

    //     for(auto neigh : adj[u]){
    //         int v = neigh.first;
    //         int w = neigh.second;

    //         if(!vis[v]){
    //             pq.push({w, v});
    //         }
    //     }
    // }

    // if(cnt == n){ // no. of nodes
    //     cout << cost << "\n";
    // }
    // else{
    //     cout << "IMPOSSIBLE" << "\n";
    // }
}