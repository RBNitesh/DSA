// State-Space(Multidimensional Dijkstra)
// UseCase: Find shortest with some constraints/rules(like., you can turn at most k edge weight to 0).

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll INF = LONG_MAX;

struct State{
    ll cost;
    int node;
    int coupon_used;

    bool operator>(const State& other) const{
        return cost > other.cost;
    }
};

ll findCheapestRoute(int node, int dest, vector<vector<pair<int,int>>> &adj){
    int n = adj.size();

    vector<vector<ll>> minCost(n, vector<ll>(2, INF));
    priority_queue<State, vector<State>, greater<State>> pq;

    pq.push(State{0, node, 0});
    minCost[node][0] = 0;

    while(!pq.empty()){
        State curr = pq.top();
        pq.pop();

        if(curr.node == dest)
            break;

        if(minCost[curr.node][curr.coupon_used] < curr.cost)
            continue;
        
        for(auto neigh : adj[curr.node]){
            int v = neigh.first, localCost = neigh.second;

            if(curr.cost + localCost < minCost[v][curr.coupon_used]){
                minCost[v][curr.coupon_used] = curr.cost + localCost;
                pq.push(State{curr.cost + localCost, v, curr.coupon_used});
            }

            if(curr.coupon_used == 0){
                if(curr.cost + localCost/2 < minCost[v][curr.coupon_used+1]){
                    minCost[v][curr.coupon_used+1] = curr.cost + localCost/2;
                    pq.push(State{curr.cost + localCost/2, v, curr.coupon_used+1});
                }
            }
        }
    }
    return min(minCost[dest][0], minCost[dest][1]);
}

int main(){
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int, int>>> adj(n + 1);

    for (int i = 1; i <= m; i++){
        int u, v, w;    
        cin >> u >> v >> w;

        adj[u].push_back({v, w}); // unidirected edge
    }

    ll res = findCheapestRoute(1, n, adj);

    cout << res << "\n";
}