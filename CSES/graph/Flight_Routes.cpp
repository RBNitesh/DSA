// Find k-shortest paths
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

struct State{
    ll d;
    int node;

    bool operator>(const State& other) const{
        return d > other.d;
    }
};

void dijkstra(int src, int dest, int k, vector<vector<pair<int,int>>> &adj){
    int N = adj.size();

    vector<priority_queue<ll>> dist(N+1);

    vector<ll> bestPaths;

    priority_queue<State,vector<State>, greater<State>> pq;
    pq.push(State{0, src});
    dist[src].push(0);

    while(!pq.empty()){
        State curr = pq.top();
        pq.pop();

        if(curr.node == dest){
            bestPaths.push_back(curr.d);

            if(bestPaths.size() == k)
                break;
        }

        // stop the entry of stale nodes in priorityqueue
        if(dist[curr.node].size() == k && dist[curr.node].top() < curr.d) 
            continue;

        for(auto neigh : adj[curr.node]){
            int v = neigh.first, wt = neigh.second;

            if(dist[v].size() < k){
                dist[v].push(curr.d + wt);
                pq.push({curr.d + wt, v});
            }
            else if(curr.d + wt < dist[v].top()){
                dist[v].pop();
                dist[v].push(curr.d + wt);
                pq.push({curr.d + wt, v});
            }
        }
    }


    for (int i = 0; i < k; i++){
        if(i > 0)
            cout << " ";
        cout << bestPaths[i];
    }
    cout << "\n";
}

int main(){
    int N, M, K;
    cin >> N >> M >> K;

    vector<vector<pair<int, int>>> adj(N + 1);
    for (int i = 1; i <= M; i++){
        int u, v, w;
        cin >> u >> v >> w;

        adj[u].push_back({v, w});
    }

    dijkstra(1, N, K, adj);
}