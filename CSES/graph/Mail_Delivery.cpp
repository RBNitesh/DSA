/*
    Tag: Euler Circuit
    Condition for euler circuit:
    1. All nodes are of even degree
    2. All the nodes with non-zero degree must be connected
    3. Print euler's circuit using hierholzer's algorithm
*/

#include<bits/stdc++.h>
using namespace std;

vector<vector<pair<int,int>>> adj;
vector<int> degree;
vector<bool> vis;
vector<int> eulerCircuit;
vector<int> seen;

// Hierholzer's Algorithm
void hierholzerAlgorithm(int node){
    while(adj[node].size()){
        auto next = adj[node].back();
        adj[node].pop_back();

        if(seen[next.second])
            continue;

        seen[next.second] = true;

        hierholzerAlgorithm(next.first);
    }

    eulerCircuit.push_back(node);
}

void dfs(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(auto& next : adj[node])
        dfs(next.first);
}

int main(){
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    degree.resize(n + 1);
    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back({v, i});
        adj[v].push_back({u, i});
        degree[u]++;
        degree[v]++;
    }

    vis.assign(n + 1, false);
    for (int i = 0; i <= n; i++){
        if(degree[i] != 0){
            dfs(i);
            break;
        }
    }

    // check if there exist a euler circuit
    for (int i = 1; i <= n; i++){
        if(degree[i] & 1) { // if node is of odd degree
            cout << "IMPOSSIBLE\n";
            return 0;
        }

        if(degree[i] == 0) // zero-degree node
            continue;
        
        if(!vis[i]){ // non-zero disconnected node
            cout << "IMPOSSIBLE\n";
            return 0;
        }
    }

    int startNode = 1; // this is given as starting point in problem
    if(degree[startNode] == 0 && m > 0){ // if starting point is disconnected
        cout << "IMPOSSIBLE\n";
        return 0;
    }

    seen.assign(m + 1, false);
    hierholzerAlgorithm(startNode);

    for (int i = 0; i < eulerCircuit.size(); i++){
        if(i > 0)
            cout << " ";
        cout << eulerCircuit[i];
    }
    cout << "\n";
}