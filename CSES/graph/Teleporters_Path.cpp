/*
    Tag: Euler's Path, Heirholzer's Algorithm
    
    Note: In this problem 1 and n are given as start and end point. Also,
        n >= 2 it means start and end can not be the same. Therefore condition
        for the degree of 1 and n would be different than euler circuit. Start
        node (i.e., 1) should have one extra outgoing edge, and end node (i.e., n)
        must have one extra incoming edge.

    --Euler Circuit is a special case of Euler Path where start and end node are same.
*/

#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;
vector<int> indegree;
vector<int> outdegree;
vector<int> eulerPath;
vector<bool> vis;

void heirholzersAlgorithm(int node){
    while(adj[node].size()){
        int next = adj[node].back();
        adj[node].pop_back();

        heirholzersAlgorithm(next);
    }
    eulerPath.push_back(node);
}

void dfs(int node){
    if(vis[node])
        return;

    vis[node] = true;

    for(int v : adj[node])
        dfs(v);
}

int main(){
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    indegree.assign(n + 1, 0);
    outdegree.assign(n + 1, 0);

    for (int i = 1; i <= m; i++){
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        indegree[v]++;
        outdegree[u]++;
    }

    vis.assign(n + 1, false);
    dfs(1);

    // check if euler path is possible 
    for (int i = 1; i <= n; i++){
        if(!vis[i]){
            if(indegree[i] == 0 && outdegree[i] == 0)
                continue;
            
            cout << "IMPOSSIBLE\n";
            return 0;
        }

        else if(i == 1 || i == n){
            if(i == 1 && outdegree[i] == indegree[i] + 1)
                continue;

            else if(i == n && indegree[i] == outdegree[i] + 1)
                continue;
            
            cout << "IMPOSSIBLE\n";
            return 0; 
        }

        else{ // i != 1 && i != n
            if(indegree[i] == outdegree[i])
                continue;
            
            cout << "IMPOSSIBLE\n";
            return 0;
        }
    }

    heirholzersAlgorithm(1);
    reverse(eulerPath.begin(), eulerPath.end());

    for (int i = 0; i < eulerPath.size(); i++){
        if(i > 0)
            cout << " ";
        cout << eulerPath[i];
    }
    cout << "\n";
}